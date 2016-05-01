package com.kim.chatroom;

import com.kim.chatroom.Message;

import net.sf.json.JSONObject;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint(value = "/game")
public class Socket {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    static Map<String,Session> sessionMap = new Hashtable<String,Session>();
    static Set<String> users = new HashSet<String>();
    @OnOpen
    public void onOpen(Session session) {
    	sessionMap.put(session.getId(), session);
    	//broadcastAll("message",)
    }

    @OnMessage
    public void onMessage(String unscrambledWord, Session session) {
    	System.out.println(unscrambledWord);
    	broadcastAll("message",unscrambledWord);
    }                                                                                                                                                  
    /**
     * 广播给所有人
     * @param message
     */
    public static void broadcastAll(String type,String message){
    	JSONObject jsonObject = JSONObject.fromObject(message);
    	Message msg = (Message) JSONObject.toBean(jsonObject, Message.class);
    	String text = "";
    	if (msg.getType().equals("chat")) {   		
    		text = "{type:'"+msg.getType() + "',name:'"+ msg.getName() + "',msg:'"+msg.getMsg() + "'}";
    	}
    	else if (msg.getType().equals("join")) {
    		text = "{type:'"+msg.getType() + "',name:'"+ msg.getName() + "'}";
    		users.add(msg.getName());
    	}
        Set<Map.Entry<String,Session>> set = sessionMap.entrySet();
        for(Map.Entry<String,Session> i: set){
            try {
            	//System.out.println(text);
            	i.getValue().getBasicRemote().sendText(message);
            	//i.getValue().getBasicRemote().sendText("{type:'"+type+"',text:'"+message+"'}");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
    	
    	sessionMap.remove(session.getId());
        
    	logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
    
    @OnError
    public void error(Session session, java.lang.Throwable throwable){
    	sessionMap.remove(session.getId());
        System.err.println("session "+session.getId()+" error:"+throwable);
    }
}
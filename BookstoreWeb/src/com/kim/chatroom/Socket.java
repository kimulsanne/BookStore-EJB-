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
    }

    @OnMessage
    public void onMessage(String unscrambledWord, Session session) {
    	broadcastAll("message",unscrambledWord);
    }    
    
    /**
     * 广播给所有人
     * @param message
     */
    public static void broadcastAll(String type,String message){
        Set<Map.Entry<String,Session>> set = sessionMap.entrySet();
        for(Map.Entry<String,Session> i: set){
            try {
            	i.getValue().getBasicRemote().sendText(message);           	
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
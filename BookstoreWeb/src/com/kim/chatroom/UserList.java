package com.kim.chatroom;

import java.util.List;

public class UserList extends Message {
    private List<String> userlist;
    
    public UserList(List<String> userlist) {
        this.userlist = userlist;
    }
    
    public List<String> getUserList() {
        return userlist;
    }
    

    @Override
    public String toString() {
        return "[UsersMessage] " + userlist.toString();
    }
}

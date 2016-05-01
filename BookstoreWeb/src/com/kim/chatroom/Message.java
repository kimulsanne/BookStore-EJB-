package com.kim.chatroom;

public class Message {
    private String type;
    private String name;
    private String msg;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//setter¡¢getter
    public String toString() {
        return this.type + "#" + this.name + "#" + this.msg;
    }
}

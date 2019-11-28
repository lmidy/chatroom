package edu.udacity.java.nano.model;


import com.alibaba.fastjson.JSON;

public class Message {
    private MessageType type;
    private String content;
    private String username;
    private int onlineCount;

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public enum MessageType {
        ENTER,
        CHAT,
        LEAVE
    }

    public Message(MessageType type, String username, String content, int onlineCount) {
        this.type = type;
        this.username = username;
        this.content = content;
        this.onlineCount = onlineCount;
    }


    public static String jsonStr(String type, String username, String content, int onlineCount) {
        return JSON.toJSONString(new Message( MessageType.valueOf(type), username, content, onlineCount));
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
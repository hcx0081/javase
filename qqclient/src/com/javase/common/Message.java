package com.javase.common;

import java.io.Serializable;

/**
 * @Description:
 */
public class Message implements Serializable {
    public static final long serialVersionUID = 1L;
    
    private String msgType;
    
    private String sender;
    private String receiver;
    private String content;
    private String sendTime;
    
    
    public String getMsgType() {
        return msgType;
    }
    
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    
    public String getSender() {
        return sender;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public String getReceiver() {
        return receiver;
    }
    
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getSendTime() {
        return sendTime;
    }
    
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}

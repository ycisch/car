package com.project.model;

import java.util.Date;

/**
 *@Description: 聊天表
 *@Author: Administrator
 *@date: 2020/3/29
 */
public class Chat {
    private Integer chatId;

    private Integer chatSend;

    private Integer chatReceive;

    private Date chatTime;

    private String chatContent;

    private User send;

    private User receive;

    @Override
    public String toString() {
        return "Chat{" +
                "chatId=" + chatId +
                ", chatSend=" + chatSend +
                ", chatReceive=" + chatReceive +
                ", chatTime=" + chatTime +
                ", chatContent='" + chatContent + '\'' +
                ", send=" + send +
                ", receive=" + receive +
                '}';
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getChatSend() {
        return chatSend;
    }

    public void setChatSend(Integer chatSend) {
        this.chatSend = chatSend;
    }

    public Integer getChatReceive() {
        return chatReceive;
    }

    public void setChatReceive(Integer chatReceive) {
        this.chatReceive = chatReceive;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public User getSend() {
        return send;
    }

    public void setSend(User send) {
        this.send = send;
    }

    public User getReceive() {
        return receive;
    }

    public void setReceive(User receive) {
        this.receive = receive;
    }

    public Chat(Integer chatId, Integer chatSend, Integer chatReceive, Date chatTime, String chatContent, User send, User receive) {
        this.chatId = chatId;
        this.chatSend = chatSend;
        this.chatReceive = chatReceive;
        this.chatTime = chatTime;
        this.chatContent = chatContent;
        this.send = send;
        this.receive = receive;
    }

    public Chat() {
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import java.io.Serializable;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Chat;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;

/**
 *
 * @author sifis
 */
public class ChatDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private String senderUid;
    private String receiverUid;
    private String type;
    private String timestamp;
    private Integer chatId, chatlistId;
    private ChatlistDTO chatList;

    public ChatDTO(Chat c) {
        message = c.getMessage();
        senderUid = c.getSenderUid();
        receiverUid = c.getReceiverUid();
        type = c.getType();
        timestamp = c.getTimestamp();
        chatId = c.getChatId();
        if (c.getChatListid() != null) {
            chatlistId = c.getChatListid().getId();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(String senderUid) {
        this.senderUid = senderUid;
    }

    public String getReceiverUid() {
        return receiverUid;
    }

    public void setReceiverUid(String receiverUid) {
        this.receiverUid = receiverUid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getChatlistId() {
        return chatlistId;
    }

    public void setChatlistId(Integer chatlistId) {
        this.chatlistId = chatlistId;
    }

    public ChatlistDTO getChatList() {
        return chatList;
    }

    public void setChatList(ChatlistDTO chatList) {
        this.chatList = chatList;
    }

    
}

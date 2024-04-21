/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import za.ac.tut.sfg.OnlineShoppingBackend.model.*;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sifis
 */
public class ChatlistDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String senderUid;
    private String receiverUid;
    private String status;
    private Integer id;
    private List<ChatDTO> chats;
    private List<ChatlistHasUserDTO> chatlistHasUserList;

    public ChatlistDTO(Chatlist c) {
        senderUid = c.getSenderUid();
        receiverUid = c.getReceiverUid();
        status = c.getStatus();
        id = c.getId();
    }

    public ChatlistDTO() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ChatDTO> getChats() {
        return chats;
    }

    public void setChats(List<ChatDTO> chats) {
        this.chats = chats;
    }

    public List<ChatlistHasUserDTO> getChatlistHasUserList() {
        return chatlistHasUserList;
    }

    public void setChatlistHasUserList(List<ChatlistHasUserDTO> chatlistHasUserList) {
        this.chatlistHasUserList = chatlistHasUserList;
    }

}

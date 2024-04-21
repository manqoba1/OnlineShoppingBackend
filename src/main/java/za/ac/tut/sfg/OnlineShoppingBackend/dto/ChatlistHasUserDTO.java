/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import za.ac.tut.sfg.OnlineShoppingBackend.model.*;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;
import java.io.Serializable;

/**
 *
 * @author sifis
 */
public class ChatlistHasUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer chatListUserId, userId, chatListId;
    private ChatlistDTO chatList;
    private UserDTO user;

    public ChatlistHasUserDTO() {
    }

    public ChatlistHasUserDTO(ChatlistHasUser chu) {
        chatListUserId = chu.getChatListuserid();
        if (chu.getUserId() != null) {
            userId = chu.getUserId().getId();
        }
        if (chu.getChatListchatListId() != null) {
            chatListId = chu.getChatListchatListId().getId();
        }
    }

    public Integer getChatListUserId() {
        return chatListUserId;
    }

    public void setChatListUserId(Integer chatListUserId) {
        this.chatListUserId = chatListUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChatListId() {
        return chatListId;
    }

    public void setChatListId(Integer chatListId) {
        this.chatListId = chatListId;
    }

    public ChatlistDTO getChatList() {
        return chatList;
    }

    public void setChatList(ChatlistDTO chatList) {
        this.chatList = chatList;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}

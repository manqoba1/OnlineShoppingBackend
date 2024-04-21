/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author sifis
 */
@Entity
@Table(name = "chatlist_has_user")
@NamedQueries({
    @NamedQuery(name = "ChatlistHasUser.findAll", query = "SELECT c FROM ChatlistHasUser c"),
    @NamedQuery(name = "ChatlistHasUser.findByChatListuserid", query = "SELECT c FROM ChatlistHasUser c WHERE c.chatListuserid = :chatListuserid")})
public class ChatlistHasUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chatList_user_id")
    private Integer chatListuserid;
    @JoinColumn(name = "chatList_chatListId", referencedColumnName = "id")
    @ManyToOne
    private Chatlist chatListchatListId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public ChatlistHasUser() {
    }

    public ChatlistHasUser(Integer chatListuserid) {
        this.chatListuserid = chatListuserid;
    }

    public Integer getChatListuserid() {
        return chatListuserid;
    }

    public void setChatListuserid(Integer chatListuserid) {
        this.chatListuserid = chatListuserid;
    }

    public Chatlist getChatListchatListId() {
        return chatListchatListId;
    }

    public void setChatListchatListId(Chatlist chatListchatListId) {
        this.chatListchatListId = chatListchatListId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatListuserid != null ? chatListuserid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatlistHasUser)) {
            return false;
        }
        ChatlistHasUser other = (ChatlistHasUser) object;
        if ((this.chatListuserid == null && other.chatListuserid != null) || (this.chatListuserid != null && !this.chatListuserid.equals(other.chatListuserid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.ChatlistHasUser[ chatListuserid=" + chatListuserid + " ]";
    }
    
}

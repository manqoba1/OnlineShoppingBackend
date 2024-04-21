/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@Table(name = "chat")
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c"),
    @NamedQuery(name = "Chat.findBySenderUid", query = "SELECT c FROM Chat c WHERE c.senderUid = :senderUid"),
    @NamedQuery(name = "Chat.findByReceiverUid", query = "SELECT c FROM Chat c WHERE c.receiverUid = :receiverUid"),
    @NamedQuery(name = "Chat.findByType", query = "SELECT c FROM Chat c WHERE c.type = :type"),
    @NamedQuery(name = "Chat.findByTimestamp", query = "SELECT c FROM Chat c WHERE c.timestamp = :timestamp"),
    @NamedQuery(name = "Chat.findByChatId", query = "SELECT c FROM Chat c WHERE c.chatId = :chatId")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "sender_uid")
    private String senderUid;
    @Basic(optional = false)
    @Column(name = "receiver_uid")
    private String receiverUid;
    @Column(name = "type")
    private String type;
    @Column(name = "timestamp")
    private String timestamp;
    @Id
    @Basic(optional = false)
    @Column(name = "chatId")
    private Integer chatId;
    @Lob
    @Column(name = "image_url")
    private String imageUrl;
    @JoinColumn(name = "chatList_id", referencedColumnName = "id")
    @ManyToOne
    private Chatlist chatListid;

    public Chat() {
    }

    public Chat(Integer chatId) {
        this.chatId = chatId;
    }

    public Chat(Integer chatId, String message, String senderUid, String receiverUid) {
        this.chatId = chatId;
        this.message = message;
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Chatlist getChatListid() {
        return chatListid;
    }

    public void setChatListid(Chatlist chatListid) {
        this.chatListid = chatListid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatId != null ? chatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.chatId == null && other.chatId != null) || (this.chatId != null && !this.chatId.equals(other.chatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Chat[ chatId=" + chatId + " ]";
    }
    
}

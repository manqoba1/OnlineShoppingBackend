/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "chatlist")
@NamedQueries({
    @NamedQuery(name = "Chatlist.findAll", query = "SELECT c FROM Chatlist c")})
public class Chatlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "sender_uid")
    private String senderUid;
    @Basic(optional = false)
    @Column(name = "receiver_uid")
    private String receiverUid;
    @Column(name = "status")
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chatListId")
    private Integer chatListId;
    @JoinColumn(name = "stylist_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stylist stylist;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Chatlist() {
    }

    public Chatlist(Integer chatListId) {
        this.chatListId = chatListId;
    }

    public Chatlist(Integer chatListId, String senderUid, String receiverUid) {
        this.chatListId = chatListId;
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
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

    public Integer getChatListId() {
        return chatListId;
    }

    public void setChatListId(Integer chatListId) {
        this.chatListId = chatListId;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chatListId != null ? chatListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatlist)) {
            return false;
        }
        Chatlist other = (Chatlist) object;
        if ((this.chatListId == null && other.chatListId != null) || (this.chatListId != null && !this.chatListId.equals(other.chatListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Chatlist[ chatListId=" + chatListId + " ]";
    }
    
}

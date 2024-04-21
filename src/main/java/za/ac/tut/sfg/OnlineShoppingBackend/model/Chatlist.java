/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sifis
 */
@Entity
@Table(name = "chatlist")
@NamedQueries({
    @NamedQuery(name = "Chatlist.findAll", query = "SELECT c FROM Chatlist c"),
    @NamedQuery(name = "Chatlist.findBySenderUid", query = "SELECT c FROM Chatlist c WHERE c.senderUid = :senderUid"),
    @NamedQuery(name = "Chatlist.findByReceiverUid", query = "SELECT c FROM Chatlist c WHERE c.receiverUid = :receiverUid"),
    @NamedQuery(name = "Chatlist.findByStatus", query = "SELECT c FROM Chatlist c WHERE c.status = :status"),
    @NamedQuery(name = "Chatlist.findById", query = "SELECT c FROM Chatlist c WHERE c.id = :id")})
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
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "chatListid")
    private List<Chat> chatList;
    @OneToMany(mappedBy = "chatListchatListId")
    private List<ChatlistHasUser> chatlistHasUserList;

    public Chatlist() {
    }

    public Chatlist(Integer id) {
        this.id = id;
    }

    public Chatlist(Integer id, String senderUid, String receiverUid) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public List<ChatlistHasUser> getChatlistHasUserList() {
        return chatlistHasUserList;
    }

    public void setChatlistHasUserList(List<ChatlistHasUser> chatlistHasUserList) {
        this.chatlistHasUserList = chatlistHasUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatlist)) {
            return false;
        }
        Chatlist other = (Chatlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Chatlist[ id=" + id + " ]";
    }
    
}

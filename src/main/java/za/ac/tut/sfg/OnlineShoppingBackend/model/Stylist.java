/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sifis
 */
@Entity
@Table(name = "stylist")
@NamedQueries({
    @NamedQuery(name = "Stylist.findAll", query = "SELECT s FROM Stylist s")})
public class Stylist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "cell")
    private String cell;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "image_url")
    private String imageUrl;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Column(name = "stylist_uid")
    private String stylistUid;
    @Column(name = "active_status")
    private String activeStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stylist", fetch = FetchType.LAZY)
    private List<Chatlist> chatlistList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stylist", fetch = FetchType.LAZY)
    private List<Address> addressList;
    @OneToMany(mappedBy = "stylist", fetch = FetchType.LAZY)
    private List<Shopcart> shopcartList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stylist", fetch = FetchType.LAZY)
    private List<Chat> chatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stylist", fetch = FetchType.LAZY)
    private List<Stylistshopcartitem> stylistshopcartitemList;

    public Stylist() {
    }

    public Stylist(Integer id) {
        this.id = id;
    }

    public Stylist(Integer id, String name, String surname, String email, String cell, Date dob, String imageUrl, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cell = cell;
        this.dob = dob;
        this.imageUrl = imageUrl;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStylistUid() {
        return stylistUid;
    }

    public void setStylistUid(String stylistUid) {
        this.stylistUid = stylistUid;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public List<Chatlist> getChatlistList() {
        return chatlistList;
    }

    public void setChatlistList(List<Chatlist> chatlistList) {
        this.chatlistList = chatlistList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Shopcart> getShopcartList() {
        return shopcartList;
    }

    public void setShopcartList(List<Shopcart> shopcartList) {
        this.shopcartList = shopcartList;
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public List<Stylistshopcartitem> getStylistshopcartitemList() {
        return stylistshopcartitemList;
    }

    public void setStylistshopcartitemList(List<Stylistshopcartitem> stylistshopcartitemList) {
        this.stylistshopcartitemList = stylistshopcartitemList;
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
        if (!(object instanceof Stylist)) {
            return false;
        }
        Stylist other = (Stylist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Stylist[ id=" + id + " ]";
    }
    
}

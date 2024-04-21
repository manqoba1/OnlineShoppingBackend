/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByCell", query = "SELECT u FROM User u WHERE u.cell = :cell"),
    @NamedQuery(name = "User.findByDob", query = "SELECT u FROM User u WHERE u.dob = :dob"),
    @NamedQuery(name = "User.findByUserUid", query = "SELECT u FROM User u WHERE u.userUid = :userUid"),
    @NamedQuery(name = "User.findByActiveStatus", query = "SELECT u FROM User u WHERE u.activeStatus = :activeStatus")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "cell")
    private String cell;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Lob
    @Column(name = "image_url")
    private String imageUrl;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Column(name = "user_uid")
    private String userUid;
    @Column(name = "active_status")
    private String activeStatus;
    @OneToMany(mappedBy = "userId")
    private List<Address> addressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Shopcart> shopcartList;
    @JoinColumn(name = "userrole_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Userrole userroleId;
    @OneToMany(mappedBy = "userId")
    private List<ChatlistHasUser> chatlistHasUserList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
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

    public Userrole getUserroleId() {
        return userroleId;
    }

    public void setUserroleId(Userrole userroleId) {
        this.userroleId = userroleId;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.User[ id=" + id + " ]";
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "shopcart")
@NamedQueries({
    @NamedQuery(name = "Shopcart.findAll", query = "SELECT s FROM Shopcart s"),
    @NamedQuery(name = "Shopcart.findById", query = "SELECT s FROM Shopcart s WHERE s.id = :id"),
    @NamedQuery(name = "Shopcart.findByTotalAmout", query = "SELECT s FROM Shopcart s WHERE s.totalAmout = :totalAmout"),
    @NamedQuery(name = "Shopcart.findByDiscount", query = "SELECT s FROM Shopcart s WHERE s.discount = :discount"),
    @NamedQuery(name = "Shopcart.findByStylistUid", query = "SELECT s FROM Shopcart s WHERE s.stylistUid = :stylistUid"),
    @NamedQuery(name = "Shopcart.findByUserUid", query = "SELECT s FROM Shopcart s WHERE s.userUid = :userUid"),
    @NamedQuery(name = "Shopcart.findByOrderStatusId", query = "SELECT s FROM Shopcart s WHERE s.orderStatusId = :orderStatusId"),
    @NamedQuery(name = "Shopcart.findByOrderId", query = "SELECT s FROM Shopcart s WHERE s.orderId = :orderId"),
    @NamedQuery(name = "Shopcart.findByOrderDate", query = "SELECT s FROM Shopcart s WHERE s.orderDate = :orderDate")})
public class Shopcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "total_amout")
    private double totalAmout;
    @Basic(optional = false)
    @Column(name = "discount")
    private double discount;
    @Column(name = "stylist_uid")
    private String stylistUid;
    @Column(name = "user_uid")
    private String userUid;
    @Column(name = "order_status_id")
    private Integer orderStatusId;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "order_date")
    private String orderDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopcartId")
    private List<Shopcartitem> shopcartitemList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Shopcart() {
    }

    public Shopcart(Integer id) {
        this.id = id;
    }

    public Shopcart(Integer id, double totalAmout, double discount) {
        this.id = id;
        this.totalAmout = totalAmout;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(double totalAmout) {
        this.totalAmout = totalAmout;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStylistUid() {
        return stylistUid;
    }

    public void setStylistUid(String stylistUid) {
        this.stylistUid = stylistUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Shopcartitem> getShopcartitemList() {
        return shopcartitemList;
    }

    public void setShopcartitemList(List<Shopcartitem> shopcartitemList) {
        this.shopcartitemList = shopcartitemList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shopcart)) {
            return false;
        }
        Shopcart other = (Shopcart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcart[ id=" + id + " ]";
    }
    
}

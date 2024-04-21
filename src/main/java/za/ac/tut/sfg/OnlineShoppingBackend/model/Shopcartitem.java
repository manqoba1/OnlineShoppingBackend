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
@Table(name = "shopcartitem")
@NamedQueries({
    @NamedQuery(name = "Shopcartitem.findAll", query = "SELECT s FROM Shopcartitem s"),
    @NamedQuery(name = "Shopcartitem.findById", query = "SELECT s FROM Shopcartitem s WHERE s.id = :id"),
    @NamedQuery(name = "Shopcartitem.findByHistory", query = "SELECT s FROM Shopcartitem s WHERE s.history = :history"),
    @NamedQuery(name = "Shopcartitem.findByOrderItemStatus", query = "SELECT s FROM Shopcartitem s WHERE s.orderItemStatus = :orderItemStatus"),
    @NamedQuery(name = "Shopcartitem.findByOrderId", query = "SELECT s FROM Shopcartitem s WHERE s.orderId = :orderId")})
public class Shopcartitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "quantity")
    private String quantity;
    @Lob
    @Column(name = "comments")
    private String comments;
    @Column(name = "history")
    private Integer history;
    @Column(name = "order_item_status")
    private Integer orderItemStatus;
    @Column(name = "order_id")
    private String orderId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "shopcart_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shopcart shopcartId;

    public Shopcartitem() {
    }

    public Shopcartitem(Integer id) {
        this.id = id;
    }

    public Shopcartitem(Integer id, String quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public Integer getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(Integer orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Shopcart getShopcartId() {
        return shopcartId;
    }

    public void setShopcartId(Shopcart shopcartId) {
        this.shopcartId = shopcartId;
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
        if (!(object instanceof Shopcartitem)) {
            return false;
        }
        Shopcartitem other = (Shopcartitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcartitem[ id=" + id + " ]";
    }
    
}

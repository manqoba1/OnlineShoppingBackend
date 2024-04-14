/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @NamedQuery(name = "Shopcart.findById", query = "SELECT s FROM Shopcart s WHERE s.shopcartPK.id = :id"),
    @NamedQuery(name = "Shopcart.findByStylistId", query = "SELECT s FROM Shopcart s WHERE s.stylistId = :stylistId"),
    @NamedQuery(name = "Shopcart.findByCustomerId", query = "SELECT s FROM Shopcart s WHERE s.customerId = :customerId"),
    @NamedQuery(name = "Shopcart.findByTotalAmout", query = "SELECT s FROM Shopcart s WHERE s.totalAmout = :totalAmout"),
    @NamedQuery(name = "Shopcart.findByTotalCartItems", query = "SELECT s FROM Shopcart s WHERE s.totalCartItems = :totalCartItems"),
    @NamedQuery(name = "Shopcart.findByUserId", query = "SELECT s FROM Shopcart s WHERE s.shopcartPK.userId = :userId")})
public class Shopcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShopcartPK shopcartPK;
    @Column(name = "stylistId")
    private Integer stylistId;
    @Basic(optional = false)
    @Column(name = "customerId")
    private int customerId;
    @Basic(optional = false)
    @Column(name = "TotalAmout")
    private long totalAmout;
    @Basic(optional = false)
    @Column(name = "totalCartItems")
    private int totalCartItems;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopcartId", fetch = FetchType.LAZY)
    private List<Shopcartitem> shopcartitemList;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public Shopcart() {
    }

    public Shopcart(ShopcartPK shopcartPK) {
        this.shopcartPK = shopcartPK;
    }

    public Shopcart(ShopcartPK shopcartPK, int customerId, long totalAmout, int totalCartItems) {
        this.shopcartPK = shopcartPK;
        this.customerId = customerId;
        this.totalAmout = totalAmout;
        this.totalCartItems = totalCartItems;
    }

    public Shopcart(int id, int userId) {
        this.shopcartPK = new ShopcartPK(id, userId);
    }

    public ShopcartPK getShopcartPK() {
        return shopcartPK;
    }

    public void setShopcartPK(ShopcartPK shopcartPK) {
        this.shopcartPK = shopcartPK;
    }

    public Integer getStylistId() {
        return stylistId;
    }

    public void setStylistId(Integer stylistId) {
        this.stylistId = stylistId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(long totalAmout) {
        this.totalAmout = totalAmout;
    }

    public int getTotalCartItems() {
        return totalCartItems;
    }

    public void setTotalCartItems(int totalCartItems) {
        this.totalCartItems = totalCartItems;
    }

    public List<Shopcartitem> getShopcartitemList() {
        return shopcartitemList;
    }

    public void setShopcartitemList(List<Shopcartitem> shopcartitemList) {
        this.shopcartitemList = shopcartitemList;
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
        hash += (shopcartPK != null ? shopcartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shopcart)) {
            return false;
        }
        Shopcart other = (Shopcart) object;
        if ((this.shopcartPK == null && other.shopcartPK != null) || (this.shopcartPK != null && !this.shopcartPK.equals(other.shopcartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcart[ shopcartPK=" + shopcartPK + " ]";
    }
    
}

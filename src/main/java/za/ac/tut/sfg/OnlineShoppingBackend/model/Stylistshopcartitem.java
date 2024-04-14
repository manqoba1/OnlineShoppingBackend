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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author sifis
 */
@Entity
@Table(name = "stylistshopcartitem")
@NamedQueries({
    @NamedQuery(name = "Stylistshopcartitem.findAll", query = "SELECT s FROM Stylistshopcartitem s"),
    @NamedQuery(name = "Stylistshopcartitem.findById", query = "SELECT s FROM Stylistshopcartitem s WHERE s.id = :id"),
    @NamedQuery(name = "Stylistshopcartitem.findByShopcartitemId", query = "SELECT s FROM Stylistshopcartitem s WHERE s.shopcartitemId = :shopcartitemId"),
    @NamedQuery(name = "Stylistshopcartitem.findByStylistId", query = "SELECT s FROM Stylistshopcartitem s WHERE s.stylistId = :stylistId")})
public class Stylistshopcartitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "shopcartitemId")
    private int shopcartitemId;
    @Basic(optional = false)
    @Column(name = "stylistId")
    private int stylistId;
    @Basic(optional = false)
    @Lob
    @Column(name = "comments")
    private String comments;

    public Stylistshopcartitem() {
    }

    public Stylistshopcartitem(Integer id) {
        this.id = id;
    }

    public Stylistshopcartitem(Integer id, int shopcartitemId, int stylistId, String comments) {
        this.id = id;
        this.shopcartitemId = shopcartitemId;
        this.stylistId = stylistId;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getShopcartitemId() {
        return shopcartitemId;
    }

    public void setShopcartitemId(int shopcartitemId) {
        this.shopcartitemId = shopcartitemId;
    }

    public int getStylistId() {
        return stylistId;
    }

    public void setStylistId(int stylistId) {
        this.stylistId = stylistId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
        if (!(object instanceof Stylistshopcartitem)) {
            return false;
        }
        Stylistshopcartitem other = (Stylistshopcartitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Stylistshopcartitem[ id=" + id + " ]";
    }
    
}

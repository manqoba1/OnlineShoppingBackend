/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "stylistshopcartitem")
@NamedQueries({
    @NamedQuery(name = "Stylistshopcartitem.findAll", query = "SELECT s FROM Stylistshopcartitem s")})
public class Stylistshopcartitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StylistshopcartitemPK stylistshopcartitemPK;
    @Basic(optional = false)
    @Column(name = "shopcartitemId")
    private int shopcartitemId;
    @Basic(optional = false)
    @Lob
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "stylist_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stylist stylist;

    public Stylistshopcartitem() {
    }

    public Stylistshopcartitem(StylistshopcartitemPK stylistshopcartitemPK) {
        this.stylistshopcartitemPK = stylistshopcartitemPK;
    }

    public Stylistshopcartitem(StylistshopcartitemPK stylistshopcartitemPK, int shopcartitemId, String comments) {
        this.stylistshopcartitemPK = stylistshopcartitemPK;
        this.shopcartitemId = shopcartitemId;
        this.comments = comments;
    }

    public Stylistshopcartitem(int id, int stylistId) {
        this.stylistshopcartitemPK = new StylistshopcartitemPK(id, stylistId);
    }

    public StylistshopcartitemPK getStylistshopcartitemPK() {
        return stylistshopcartitemPK;
    }

    public void setStylistshopcartitemPK(StylistshopcartitemPK stylistshopcartitemPK) {
        this.stylistshopcartitemPK = stylistshopcartitemPK;
    }

    public int getShopcartitemId() {
        return shopcartitemId;
    }

    public void setShopcartitemId(int shopcartitemId) {
        this.shopcartitemId = shopcartitemId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stylistshopcartitemPK != null ? stylistshopcartitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stylistshopcartitem)) {
            return false;
        }
        Stylistshopcartitem other = (Stylistshopcartitem) object;
        if ((this.stylistshopcartitemPK == null && other.stylistshopcartitemPK != null) || (this.stylistshopcartitemPK != null && !this.stylistshopcartitemPK.equals(other.stylistshopcartitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Stylistshopcartitem[ stylistshopcartitemPK=" + stylistshopcartitemPK + " ]";
    }
    
}

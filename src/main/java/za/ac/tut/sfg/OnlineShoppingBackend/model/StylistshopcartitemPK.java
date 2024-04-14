/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author sifis
 */
@Embeddable
public class StylistshopcartitemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "stylist_id")
    private int stylistId;

    public StylistshopcartitemPK() {
    }

    public StylistshopcartitemPK(int id, int stylistId) {
        this.id = id;
        this.stylistId = stylistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStylistId() {
        return stylistId;
    }

    public void setStylistId(int stylistId) {
        this.stylistId = stylistId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) stylistId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StylistshopcartitemPK)) {
            return false;
        }
        StylistshopcartitemPK other = (StylistshopcartitemPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.stylistId != other.stylistId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.StylistshopcartitemPK[ id=" + id + ", stylistId=" + stylistId + " ]";
    }
    
}

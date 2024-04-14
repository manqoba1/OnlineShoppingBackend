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
public class AddressPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "addressId")
    private int addressId;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public AddressPK() {
    }

    public AddressPK(int addressId, int userId) {
        this.addressId = addressId;
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) addressId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressPK)) {
            return false;
        }
        AddressPK other = (AddressPK) object;
        if (this.addressId != other.addressId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.AddressPK[ addressId=" + addressId + ", userId=" + userId + " ]";
    }
    
}

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
public class ProductcolorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId1;

    public ProductcolorPK() {
    }

    public ProductcolorPK(int id, int productId1) {
        this.id = id;
        this.productId1 = productId1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId1() {
        return productId1;
    }

    public void setProductId1(int productId1) {
        this.productId1 = productId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) productId1;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductcolorPK)) {
            return false;
        }
        ProductcolorPK other = (ProductcolorPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.productId1 != other.productId1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.ProductcolorPK[ id=" + id + ", productId1=" + productId1 + " ]";
    }
    
}

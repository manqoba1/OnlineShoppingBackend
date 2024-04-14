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
public class ShopcartitemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "productcolor_id")
    private int productcolorId;
    @Basic(optional = false)
    @Column(name = "productcolor_product_id")
    private int productcolorProductId;
    @Basic(optional = false)
    @Column(name = "productsize_id")
    private int productsizeId;
    @Basic(optional = false)
    @Column(name = "productsize_product_id")
    private int productsizeProductId;

    public ShopcartitemPK() {
    }

    public ShopcartitemPK(int id, int productcolorId, int productcolorProductId, int productsizeId, int productsizeProductId) {
        this.id = id;
        this.productcolorId = productcolorId;
        this.productcolorProductId = productcolorProductId;
        this.productsizeId = productsizeId;
        this.productsizeProductId = productsizeProductId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductcolorId() {
        return productcolorId;
    }

    public void setProductcolorId(int productcolorId) {
        this.productcolorId = productcolorId;
    }

    public int getProductcolorProductId() {
        return productcolorProductId;
    }

    public void setProductcolorProductId(int productcolorProductId) {
        this.productcolorProductId = productcolorProductId;
    }

    public int getProductsizeId() {
        return productsizeId;
    }

    public void setProductsizeId(int productsizeId) {
        this.productsizeId = productsizeId;
    }

    public int getProductsizeProductId() {
        return productsizeProductId;
    }

    public void setProductsizeProductId(int productsizeProductId) {
        this.productsizeProductId = productsizeProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) productcolorId;
        hash += (int) productcolorProductId;
        hash += (int) productsizeId;
        hash += (int) productsizeProductId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShopcartitemPK)) {
            return false;
        }
        ShopcartitemPK other = (ShopcartitemPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.productcolorId != other.productcolorId) {
            return false;
        }
        if (this.productcolorProductId != other.productcolorProductId) {
            return false;
        }
        if (this.productsizeId != other.productsizeId) {
            return false;
        }
        if (this.productsizeProductId != other.productsizeProductId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.ShopcartitemPK[ id=" + id + ", productcolorId=" + productcolorId + ", productcolorProductId=" + productcolorProductId + ", productsizeId=" + productsizeId + ", productsizeProductId=" + productsizeProductId + " ]";
    }
    
}

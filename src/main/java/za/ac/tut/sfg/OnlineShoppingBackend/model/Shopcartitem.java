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
import jakarta.persistence.JoinColumns;
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
    @NamedQuery(name = "Shopcartitem.findAll", query = "SELECT s FROM Shopcartitem s")})
public class Shopcartitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShopcartitemPK shopcartitemPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "quantity")
    private String quantity;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;
    @JoinColumns({
        @JoinColumn(name = "productcolor_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "productcolor_product_id", referencedColumnName = "product_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productcolor productcolor;
    @JoinColumns({
        @JoinColumn(name = "productsize_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "productsize_product_id", referencedColumnName = "product_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Productsize productsize;

    public Shopcartitem() {
    }

    public Shopcartitem(ShopcartitemPK shopcartitemPK) {
        this.shopcartitemPK = shopcartitemPK;
    }

    public Shopcartitem(ShopcartitemPK shopcartitemPK, String quantity) {
        this.shopcartitemPK = shopcartitemPK;
        this.quantity = quantity;
    }

    public Shopcartitem(int id, int productcolorId, int productcolorProductId, int productsizeId, int productsizeProductId) {
        this.shopcartitemPK = new ShopcartitemPK(id, productcolorId, productcolorProductId, productsizeId, productsizeProductId);
    }

    public ShopcartitemPK getShopcartitemPK() {
        return shopcartitemPK;
    }

    public void setShopcartitemPK(ShopcartitemPK shopcartitemPK) {
        this.shopcartitemPK = shopcartitemPK;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Productcolor getProductcolor() {
        return productcolor;
    }

    public void setProductcolor(Productcolor productcolor) {
        this.productcolor = productcolor;
    }

    public Productsize getProductsize() {
        return productsize;
    }

    public void setProductsize(Productsize productsize) {
        this.productsize = productsize;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopcartitemPK != null ? shopcartitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shopcartitem)) {
            return false;
        }
        Shopcartitem other = (Shopcartitem) object;
        if ((this.shopcartitemPK == null && other.shopcartitemPK != null) || (this.shopcartitemPK != null && !this.shopcartitemPK.equals(other.shopcartitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcartitem[ shopcartitemPK=" + shopcartitemPK + " ]";
    }
    
}

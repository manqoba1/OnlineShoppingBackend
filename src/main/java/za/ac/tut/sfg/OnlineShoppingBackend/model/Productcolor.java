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
@Table(name = "productcolor")
@NamedQueries({
    @NamedQuery(name = "Productcolor.findAll", query = "SELECT p FROM Productcolor p")})
public class Productcolor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductcolorPK productcolorPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productcolor", fetch = FetchType.LAZY)
    private List<Shopcartitem> shopcartitemList;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;

    public Productcolor() {
    }

    public Productcolor(ProductcolorPK productcolorPK) {
        this.productcolorPK = productcolorPK;
    }

    public Productcolor(ProductcolorPK productcolorPK, String name) {
        this.productcolorPK = productcolorPK;
        this.name = name;
    }

    public Productcolor(int id, int productId) {
        this.productcolorPK = new ProductcolorPK(id, productId);
    }

    public ProductcolorPK getProductcolorPK() {
        return productcolorPK;
    }

    public void setProductcolorPK(ProductcolorPK productcolorPK) {
        this.productcolorPK = productcolorPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shopcartitem> getShopcartitemList() {
        return shopcartitemList;
    }

    public void setShopcartitemList(List<Shopcartitem> shopcartitemList) {
        this.shopcartitemList = shopcartitemList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productcolorPK != null ? productcolorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productcolor)) {
            return false;
        }
        Productcolor other = (Productcolor) object;
        if ((this.productcolorPK == null && other.productcolorPK != null) || (this.productcolorPK != null && !this.productcolorPK.equals(other.productcolorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Productcolor[ productcolorPK=" + productcolorPK + " ]";
    }
    
}

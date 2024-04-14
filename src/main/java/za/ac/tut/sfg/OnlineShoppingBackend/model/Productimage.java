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
@Table(name = "productimage")
@NamedQueries({
    @NamedQuery(name = "Productimage.findAll", query = "SELECT p FROM Productimage p")})
public class Productimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductimagePK productimagePK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "url_full")
    private String urlFull;
    @Basic(optional = false)
    @Column(name = "url_thump")
    private String urlThump;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;

    public Productimage() {
    }

    public Productimage(ProductimagePK productimagePK) {
        this.productimagePK = productimagePK;
    }

    public Productimage(ProductimagePK productimagePK, String name, String urlFull, String urlThump) {
        this.productimagePK = productimagePK;
        this.name = name;
        this.urlFull = urlFull;
        this.urlThump = urlThump;
    }

    public Productimage(int id, int productId) {
        this.productimagePK = new ProductimagePK(id, productId);
    }

    public ProductimagePK getProductimagePK() {
        return productimagePK;
    }

    public void setProductimagePK(ProductimagePK productimagePK) {
        this.productimagePK = productimagePK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlFull() {
        return urlFull;
    }

    public void setUrlFull(String urlFull) {
        this.urlFull = urlFull;
    }

    public String getUrlThump() {
        return urlThump;
    }

    public void setUrlThump(String urlThump) {
        this.urlThump = urlThump;
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
        hash += (productimagePK != null ? productimagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productimage)) {
            return false;
        }
        Productimage other = (Productimage) object;
        if ((this.productimagePK == null && other.productimagePK != null) || (this.productimagePK != null && !this.productimagePK.equals(other.productimagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Productimage[ productimagePK=" + productimagePK + " ]";
    }
    
}

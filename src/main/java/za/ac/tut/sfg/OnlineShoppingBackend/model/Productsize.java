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
@Table(name = "productsize")
@NamedQueries({
    @NamedQuery(name = "Productsize.findAll", query = "SELECT p FROM Productsize p"),
    @NamedQuery(name = "Productsize.findById", query = "SELECT p FROM Productsize p WHERE p.productsizePK.id = :id"),
    @NamedQuery(name = "Productsize.findBySizeType", query = "SELECT p FROM Productsize p WHERE p.sizeType = :sizeType"),
    @NamedQuery(name = "Productsize.findBySize", query = "SELECT p FROM Productsize p WHERE p.size = :size"),
    @NamedQuery(name = "Productsize.findBySizeCode", query = "SELECT p FROM Productsize p WHERE p.sizeCode = :sizeCode"),
    @NamedQuery(name = "Productsize.findByProductId", query = "SELECT p FROM Productsize p WHERE p.productsizePK.productId = :productId")})
public class Productsize implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductsizePK productsizePK;
    @Basic(optional = false)
    @Column(name = "size_type")
    private String sizeType;
    @Basic(optional = false)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @Column(name = "sizeCode")
    private String sizeCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productsize", fetch = FetchType.LAZY)
    private List<Shopcartitem> shopcartitemList;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;

    public Productsize() {
    }

    public Productsize(ProductsizePK productsizePK) {
        this.productsizePK = productsizePK;
    }

    public Productsize(ProductsizePK productsizePK, String sizeType, String size, String sizeCode) {
        this.productsizePK = productsizePK;
        this.sizeType = sizeType;
        this.size = size;
        this.sizeCode = sizeCode;
    }

    public Productsize(int id, int productId) {
        this.productsizePK = new ProductsizePK(id, productId);
    }

    public ProductsizePK getProductsizePK() {
        return productsizePK;
    }

    public void setProductsizePK(ProductsizePK productsizePK) {
        this.productsizePK = productsizePK;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(String sizeCode) {
        this.sizeCode = sizeCode;
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
        hash += (productsizePK != null ? productsizePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productsize)) {
            return false;
        }
        Productsize other = (Productsize) object;
        if ((this.productsizePK == null && other.productsizePK != null) || (this.productsizePK != null && !this.productsizePK.equals(other.productsizePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.sfg.OnlineShoppingBackend.model.Productsize[ productsizePK=" + productsizePK + " ]";
    }
    
}

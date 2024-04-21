/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import za.ac.tut.sfg.OnlineShoppingBackend.model.*;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;
import java.io.Serializable;

/**
 *
 * @author sifis
 */
public class ProductImageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id, productId;
    private String urlFull;
    private String urlThump;
    private ProductDTO product;
 
    public ProductImageDTO() {
    }

    public ProductImageDTO(Productimage p) {
        id = p.getId();
        if (p.getProductId() != null) {
            productId = p.getProductId().getProductId();
//            product = new ProductDTO(p.getProductId());
        }
        urlFull = p.getUrlFull();
        urlThump = p.getUrlThump();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

}

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
public class ShopCartItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id, productId, shopCartId;
    private String quantity;
    private String comments;
    private ProductDTO product;
    private ShopCartDTO shopCart;

    private Integer history;
    private Integer orderItemStatus;
    private String orderId;

    public ShopCartItemDTO() {
    }

    public ShopCartItemDTO(Shopcartitem s) {
        id = s.getId();
        if (s.getProductId() != null) {
            productId = s.getProductId().getProductId();
        }
        if (s.getShopcartId() != null) {
            shopCartId = s.getShopcartId().getId();
        }
        history = s.getHistory();
        orderItemStatus = s.getOrderItemStatus();
        orderId = s.getOrderId();
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

    public Integer getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Integer shopCartId) {
        this.shopCartId = shopCartId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public Integer getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(Integer orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ShopCartDTO getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShopCartDTO shopCart) {
        this.shopCart = shopCart;
    }
}

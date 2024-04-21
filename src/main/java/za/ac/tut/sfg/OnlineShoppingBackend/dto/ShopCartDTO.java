/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import za.ac.tut.sfg.OnlineShoppingBackend.model.*;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;
import java.io.Serializable;
import java.util.List; 

/**
 *
 * @author sifis
 */
public class ShopCartDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id, userId;
    private double totalAmout;
    private double discount;
    private List<ShopCartItemDTO> orderItems;
    private UserDTO user;
    private String stylistUid;
    private String userUid;
    private Integer orderStatusId;
    private String orderId;
    private String orderDate;

    public ShopCartDTO() {
    }

    public ShopCartDTO(Shopcart s) {
        id = s.getId();
        if (s.getUserId() != null) {
            userId = s.getUserId().getId();
        }
        totalAmout = s.getTotalAmout();
        discount = s.getDiscount();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(double totalAmout) {
        this.totalAmout = totalAmout;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<ShopCartItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ShopCartItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getStylistUid() {
        return stylistUid;
    }

    public void setStylistUid(String stylistUid) {
        this.stylistUid = stylistUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}

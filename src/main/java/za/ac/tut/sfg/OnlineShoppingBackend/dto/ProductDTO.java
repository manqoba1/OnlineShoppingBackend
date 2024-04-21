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
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productId, categoryId;
    private int id;
    private String name;
    private String description;
    private double price;
    private CategoryDTO category;
    private List<ShopCartItemDTO> shopCartItemList;
    private List<ProductImageDTO> productImages;

    public ProductDTO() {
    }

    public ProductDTO(Product p) {
        productId = p.getProductId();
        id = p.getId();
        if (p.getCategoryId() != null) {
            categoryId = p.getCategoryId().getCategoryid();
//            category = new CategoryDTO(p.getCategoryId());
        }
        name = p.getName();
        description = p.getDescription();
        price = p.getPrice();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<ShopCartItemDTO> getShopCartItemList() {
        return shopCartItemList;
    }

    public void setShopCartItemList(List<ShopCartItemDTO> shopCartItemList) {
        this.shopCartItemList = shopCartItemList;
    }

    public List<ProductImageDTO> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImageDTO> productImages) {
        this.productImages = productImages;
    }

   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import java.io.Serializable;
import java.util.List;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Category;

/**
 *
 * @author sifis
 */
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String image;
    private Integer categoryid;
    private List<ProductDTO> products;

    public CategoryDTO(Category c) {
        categoryid = c.getCategoryid();
        id = c.getId();
        categoryid = c.getCategoryid();
        name = c.getName();
        image = c.getImage();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
    
}

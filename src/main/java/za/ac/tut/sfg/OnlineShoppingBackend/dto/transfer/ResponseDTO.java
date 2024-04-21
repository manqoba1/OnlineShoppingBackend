/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer;

import java.io.Serializable;
import java.util.List;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.AddressDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.CategoryDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ChatDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ChatlistHasUserDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ProductDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ProductImageDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ShopCartDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ShopCartItemDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserRoleDTO;

/**
 *
 * @author sifis
 */
public class ResponseDTO implements Serializable {

    private int statusCode;
    private String message = "Request is KOOL!",
            sessionID, fileString;
    private Double elapsedRequestTimeInSeconds;
    private String log;
    private ChatDTO chat;
    private UserDTO user;
    private UserRoleDTO userRole;
    private CategoryDTO category;
    private ShopCartDTO purchasedOrder;
    private List<CategoryDTO> categories;
    private List<UserDTO> users;
    private List<UserDTO> stylists;
    private List<ProductDTO> products;
    private List<ShopCartItemDTO> shopCartItemList;
    private List<ProductImageDTO> productImageList;
    private List<AddressDTO> addresses;
    private List<ShopCartDTO> shopCartList;
    private List<ChatlistHasUserDTO> chatlistHasUserList;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getFileString() {
        return fileString;
    }

    public void setFileString(String fileString) {
        this.fileString = fileString;
    }

    public Double getElapsedRequestTimeInSeconds() {
        return elapsedRequestTimeInSeconds;
    }

    public void setElapsedRequestTimeInSeconds(Double elapsedRequestTimeInSeconds) {
        this.elapsedRequestTimeInSeconds = elapsedRequestTimeInSeconds;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public ChatDTO getChat() {
        return chat;
    }

    public void setChat(ChatDTO chat) {
        this.chat = chat;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public ShopCartDTO getPurchasedOrder() {
        return purchasedOrder;
    }

    public void setPurchasedOrder(ShopCartDTO purchasedOrder) {
        this.purchasedOrder = purchasedOrder;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ShopCartItemDTO> getShopCartItemList() {
        return shopCartItemList;
    }

    public void setShopCartItemList(List<ShopCartItemDTO> shopCartItemList) {
        this.shopCartItemList = shopCartItemList;
    }

    public List<ProductImageDTO> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImageDTO> productImageList) {
        this.productImageList = productImageList;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public List<ShopCartDTO> getShopCartList() {
        return shopCartList;
    }

    public void setShopCartList(List<ShopCartDTO> shopCartList) {
        this.shopCartList = shopCartList;
    }

    public List<ChatlistHasUserDTO> getChatlistHasUserList() {
        return chatlistHasUserList;
    }

    public void setChatlistHasUserList(List<ChatlistHasUserDTO> chatlistHasUserList) {
        this.chatlistHasUserList = chatlistHasUserList;
    }

    public List<UserDTO> getStylists() {
        return stylists;
    }

    public void setStylists(List<UserDTO> stylists) {
        this.stylists = stylists;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

}

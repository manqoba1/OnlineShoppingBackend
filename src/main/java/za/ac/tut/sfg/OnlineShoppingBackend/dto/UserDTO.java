/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import za.ac.tut.sfg.OnlineShoppingBackend.model.*;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sifis
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id, userRoleId;
    private String name;
    private String surname;
    private String email;
    private String cell;
    private Long dob;
    private String imageUrl;
    private String password;
    private String userUid;
    private String activeStatus;
    private List<AddressDTO> addresses;
    private List<ShopCartDTO> shopCartList;
    private UserRoleDTO userRole;
    private List<ChatlistHasUserDTO> chatlistHasUserList;

    public UserDTO() {
    }

    public UserDTO(User u) {
        if (u != null) {
            id = u.getId();
            if (u.getUserroleId() != null) {
                userRoleId = u.getUserroleId().getId();
            }
            name = u.getName();
            surname = u.getSurname();
            email = u.getEmail();
            cell = u.getCell();
            if (u.getDob() != null) {
                dob = u.getDob().getTime();
            }
            imageUrl = u.getImageUrl();
            password = u.getPassword();
            userUid = u.getUserUid();
            activeStatus = u.getActiveStatus();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Long getDob() {
        return dob;
    }

    public void setDob(Long dob) {
        this.dob = dob;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
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

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }

    public List<ChatlistHasUserDTO> getChatlistHasUserList() {
        return chatlistHasUserList;
    }

    public void setChatlistHasUserList(List<ChatlistHasUserDTO> chatlistHasUserList) {
        this.chatlistHasUserList = chatlistHasUserList;
    }

}

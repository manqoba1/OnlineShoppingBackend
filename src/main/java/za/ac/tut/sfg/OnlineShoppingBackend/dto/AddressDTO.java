/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.dto;

import java.io.Serializable;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Address;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.*;
/**
 *
 * @author sifis
 */
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer addressId, userId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Integer active;

    private Double latitude;
    private Double longitude;
    private UserDTO user;

    public AddressDTO(Address a) {

        addressId = a.getAddressId();
        addressLine1 = a.getAddressLine1();
        addressLine2 = a.getAddressLine2();
        city = a.getCity();
        state = a.getState();
        country = a.getCountry();
        zipCode = a.getZipCode();
        active = a.getActive();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        if (a.getUserId() != null) {
            userId = a.getUserId().getId();
        }
    }

    public AddressDTO() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}

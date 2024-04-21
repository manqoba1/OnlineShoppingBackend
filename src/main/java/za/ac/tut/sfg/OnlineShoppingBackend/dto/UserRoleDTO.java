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
public class UserRoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private short status;
    private List<UserDTO> users;

    public UserRoleDTO() {
    }

    public UserRoleDTO(Userrole u) {
        id = u.getId();
        name = u.getName();
        status = u.getStatus();
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

}

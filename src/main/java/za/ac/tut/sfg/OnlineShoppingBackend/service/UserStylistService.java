/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserRoleDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer.ResponseDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;

/**
 *
 * @author sifis
 */
public interface UserStylistService {

    UserDTO loginUser(String email, String password) throws NoSuchElementException;

    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Integer userId);

    UserRoleDTO getUserRole(Integer userRoleId);

    UserDTO getUserByUid(String userUid);

    List<UserDTO> getActiveStylist(String activeStatus, int userroleId);

    UserDTO updateUser(UserDTO user);
}

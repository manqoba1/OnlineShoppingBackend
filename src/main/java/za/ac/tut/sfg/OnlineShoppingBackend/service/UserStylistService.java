/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Stylist;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;

/**
 *
 * @author sifis
 */
public interface UserStylistService {

    Optional<User> loginUser(String email, String password);
    Optional<Stylist> loginStylist(String email, String password);

    Optional<User> createUser(User user);

    Optional<Stylist> createStylist(Stylist stylist);

    Optional<?> getStylistById(Integer stylistId);

    Optional<?> getUserById(Integer userId);

    Optional<?> getStylistByUid(String stylistUid);

    Optional<?> getUserByUid(String userUid);

    Optional<List<Stylist>> getActiveStylist(String status);

    Optional<User> updateUser(User user);

    Optional<Stylist> updateStylist(Stylist stylist);

}

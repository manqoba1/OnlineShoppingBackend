/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;

/**
 *
 * @author sifis
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2")
    Optional<User> login(String email, String password);

    @Query(value = "SELECT count(u) FROM User u WHERE u.email=?1")
    long userExist(String email);

    @Query("SELECT u FROM User u WHERE u.userUid=?1")
    Optional<User> getUserByUid(String userUid);

    @Query("SELECT u FROM User u WHERE u.activeStatus = :activeStatus AND u.userroleId.id = :userroleId") //1=online 2=ofline
    Optional<List<User>> findStylistByActiveStatus(String activeStatus, int userroleId);
}

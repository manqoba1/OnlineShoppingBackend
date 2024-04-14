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
import za.ac.tut.sfg.OnlineShoppingBackend.model.Stylist;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;

/**
 *
 * @author sifis
 */
@Repository
public interface StylistRepository extends JpaRepository<Stylist, Integer> {

    @Query("SELECT u FROM Stylist u WHERE u.email=?1 AND u.password=?2")
    Optional<Stylist> login(String email, String password);

    @Query(value = "SELECT count(u) FROM Stylist u WHERE u.email=?1")
    long userExist(String email);

    @Query("SELECT s FROM Stylist s WHERE s.activeStatus = ?1")
    Optional<List<Stylist>> findStylistByActiveStatus(String activeStatus);
    
     @Query("SELECT s FROM Stylist s WHERE s.stylistUid = ?1")
    Optional<Stylist> getStylistByUid(String stylistUid) ;
}

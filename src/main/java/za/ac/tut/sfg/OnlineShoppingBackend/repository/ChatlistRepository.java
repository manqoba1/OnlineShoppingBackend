/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Chatlist;

/**
 *
 * @author sifis
 */
@Repository
public interface ChatlistRepository extends JpaRepository<Chatlist, Integer> {

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcartitem;

/**
 *
 * @author sifis
 */
public interface ShopcartItemRepository extends JpaRepository<Shopcartitem, Integer> {

}

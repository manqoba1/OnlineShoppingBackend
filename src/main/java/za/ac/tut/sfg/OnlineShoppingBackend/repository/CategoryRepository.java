/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.ac.tut.sfg.OnlineShoppingBackend.model.Category;

/**
 *
 * @author sifis
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "SELECT count(c) FROM Category c WHERE c.id=?1")
    long categoryExist(int id);

    @Query(value = "SELECT c FROM Category c WHERE c.id=?1")
    Category getCategory(int id);
}

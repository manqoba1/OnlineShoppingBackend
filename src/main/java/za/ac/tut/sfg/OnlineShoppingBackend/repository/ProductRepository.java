package za.ac.tut.sfg.OnlineShoppingBackend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.ac.tut.sfg.OnlineShoppingBackend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT s FROM Product s WHERE s.description like '%?1%' OR s.name like '%1?%'")
    Optional<List<Product>> searchProducts(String text);

    @Query("SELECT s FROM Product s WHERE s.id=?1")
    Product findProductById(int id);
}

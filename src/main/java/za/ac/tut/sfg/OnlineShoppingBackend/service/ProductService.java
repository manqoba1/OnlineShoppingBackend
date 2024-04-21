package za.ac.tut.sfg.OnlineShoppingBackend.service;

import java.util.List;
import java.util.Optional;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.CategoryDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ProductDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.gettingonlinedata.ProductLoad;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Category;
public interface ProductService {

    void createBatchProducts(List<ProductLoad> products);

    void createBatchCategories(List<Category> products);

    List<ProductDTO> searchProduct(String text);

    List<ProductDTO> findAllProduct();

    List<CategoryDTO> findAllCategories();
}

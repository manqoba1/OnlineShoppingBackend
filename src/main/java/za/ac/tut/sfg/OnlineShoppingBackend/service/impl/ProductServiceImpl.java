package za.ac.tut.sfg.OnlineShoppingBackend.service.impl;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.CategoryDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ProductDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ProductImageDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.gettingonlinedata.Image;
import za.ac.tut.sfg.OnlineShoppingBackend.gettingonlinedata.ProductLoad;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Category;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Product;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Productimage;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.CategoryRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.ProductImagesRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.ProductRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.service.ProductService;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.DateUtil;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.LoggerUtil;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public ProductImagesRepository productImagesRepository;

    @Override
    public List<ProductDTO> searchProduct(String text) {
        List<ProductDTO> response = new ArrayList<>();
        Optional<List<Product>> optionalProducts = Optional.ofNullable(searchProductsHelper(text));
        for (Product u : optionalProducts.get()) {
            ProductDTO product = new ProductDTO(u);
            product.getProductImages().addAll(getLinkedImages(u));
            response.add(product);
        }

        return response;
    }

    private List<Product> searchProductsHelper(String text) {
        return productRepository.searchProducts(text).get();
    }

    private List<Productimage> getProdtcProductimage(List<String> images, int productId) {
        LOGGER.LOG_INFO("Endpoint getProdtcProductimage(String[] images, int productId) : was hit at: " + DATEUTIL.getTime() + " by : "
                + new Gson().toJson(images),
                ProductServiceImpl.class);
        List<Productimage> productimages = new ArrayList<>();
        for (String productimage : images) {
            Productimage p = new Productimage();
            p.setUrlFull(productimage);
            Product exist = productRepository.findProductById(productId);
            if (exist == null) {
                break;
            }
            p.setProductId(exist);
            productimages.add(p);
        }
        return productimages;
    }

    public void createBatchProductImages(List<Productimage> productimages) {
        productImagesRepository.saveAllAndFlush(productimages);
    }
    LoggerUtil LOGGER = new LoggerUtil();
    DateUtil DATEUTIL = new DateUtil();

    @Override
    public void createBatchProducts(List<ProductLoad> serviceProducts) {
        productRepository.deleteAll();
        productImagesRepository.deleteAll();
        List<Product> products = new ArrayList<>();
        for (ProductLoad p : serviceProducts) {
            if (!productRepository.existsById(p.getId())) {
                LOGGER.LOG_INFO("Endpoint createProducts : was hit at: " + DATEUTIL.getTime() + " by : "
                        + new Gson().toJson(p),
                        ProductServiceImpl.class);
                LOGGER.LOG_INFO("Endpoint p.getImages() : was hit at: " + DATEUTIL.getTime() + " by : "
                        + new Gson().toJson(p.getImages()),
                        ProductServiceImpl.class);

                LOGGER.LOG_INFO("Endpoint categoryRepository.existsById(p.getCategory().getId()) : was hit at: " + DATEUTIL.getTime() + " by : "
                        + categoryRepository.categoryExist(p.getCategory().getId()),
                        ProductServiceImpl.class);
                if (categoryRepository.categoryExist(p.getCategory().getId()) == 0) {
                    continue;
                }

                Product product = new Product();
                product.setProductId(p.getId());
                product.setId(p.getId());
                product.setDescription(p.getDescription());
                product.setName(p.getTitle());
                product.setPrice(p.getPrice());
                product.setCategoryId(categoryRepository.getCategory(p.getCategory().getId()));
//                List<String> ses = new Gson().fromJson(new Gson().toJson(p.getImages()), List<String>.class);

//                product.setProductimageList(getProdtcProductimage(p.getImages(), p.getId()));
                LOGGER.LOG_INFO("Endpoint categoryRepository.existsById(p.getCategory().getId()) : was hit at: " + DATEUTIL.getTime() + " by : "
                        + categoryRepository.categoryExist(p.getCategory().getId()),
                        ProductServiceImpl.class);

                LOGGER.LOG_INFO("Endpoint product : was hit at: " + DATEUTIL.getTime() + " by : "
                        + new Gson().toJson(product),
                        ProductServiceImpl.class);
                products.add(product);

                productRepository.saveAndFlush(product);
//                new Gson().toJson(p.getImages());
//                String[] strings = new Gson().fromJson(new Gson().toJson(new Gson().toJson(p.getImages())), String[].class);
                List<String> images = p.getImages();
                int t = 0;
                for (String s : p.getImages()) {
                    LOGGER.LOG_INFO("Endpoint strings :" + t++ + " was hit at: " + DATEUTIL.getTime() + " by : "
                            + s,
                            ProductServiceImpl.class);
                }
//                ses = new Gson().fromJson(new Gson().toJson(p.getImages()), String[].class);
//                LOGGER.LOG_INFO("Endpoint strings : was hit at: " + DATEUTIL.getTime() + " by : "
//                        + ses[0],
//                        ProductServiceImpl.class);
//                String[] ima = new Gson().fromJson(ses[0],String[].class);
//                LOGGER.LOG_INFO("Endpoint ima : was hit at: " + DATEUTIL.getTime() + " by : "
//                        + ima[0],
//                        ProductServiceImpl.class);
                createBatchProductImages(getProdtcProductimage(p.getImages(), p.getId()));
            }
        }

//        UserProfile currentUserProfile = user.getUserProfile();
//        List<Address> addressSet = addressRepository.saveAll(user.getUserProfile().getAddresses());
//        currentUserProfile.getAddresses().addAll(addressSet);
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        List<ProductDTO> response = new ArrayList<>();
        Optional<List<Product>> optionalProducts = Optional.ofNullable(findAllProductHelper());
        for (Product u : optionalProducts.get()) {
            ProductDTO product = new ProductDTO(u);
            product.setProductImages(new ArrayList<>());
            product.getProductImages().addAll(getLinkedImages(u));
            response.add(product);
        }
        return response;
    }

    private List<ProductImageDTO> getLinkedImages(Product u) {
        List<ProductImageDTO> productImages = new ArrayList<>();
        for (Productimage p : u.getProductimageList()) {
            productImages.add(new ProductImageDTO(p));
        }
        return productImages;
    }

    private List<Product> findAllProductHelper() {
        return productRepository.findAll();
    }

    @Override
    public void createBatchCategories(List<Category> products) {
        categoryRepository.deleteAll();
        categoryRepository.saveAll(products);
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        List<CategoryDTO> category = new ArrayList<>();
        for (Category c : findAllCategoriesHelper()) {
            category.add(new CategoryDTO(c));
        }
        return category;
    }

    private List<Category> findAllCategoriesHelper() {
        return categoryRepository.findAll();
    }

}

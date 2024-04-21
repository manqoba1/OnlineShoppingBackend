package za.ac.tut.sfg.OnlineShoppingBackend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer.ResponseDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.gettingonlinedata.ProductLoad;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Category;

import za.ac.tut.sfg.OnlineShoppingBackend.model.Product;
import za.ac.tut.sfg.OnlineShoppingBackend.service.ProductService;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.DateUtil;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.LoggerUtil;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    LoggerUtil LOGGER = new LoggerUtil();
    DateUtil DATEUTIL = new DateUtil();

    @Autowired
    public ProductService productService;

    @GetMapping("/search/{text}")
    public ResponseEntity<ResponseDTO> searchProducts(@PathVariable("text") String text,
            @RequestHeader Map<String, String> headers) {
        ResponseDTO response = new ResponseDTO();
        LOGGER.LOG_INFO("Endpoint searchProducts : was hit at: " + DATEUTIL.getTime() + " by : ",
                ProductController.class);

        response.setProducts(productService.searchProduct(text));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findAllProducts")
    public ResponseEntity<ResponseDTO> getAllProducts(@RequestHeader Map<String, String> headers) {
        ResponseDTO response = new ResponseDTO();
        LOGGER.LOG_INFO("Endpoint getAllProducts : was hit at: " + DATEUTIL.getTime() + " by : ",
                ProductController.class);
        response.setProducts(productService.findAllProduct());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create-products")
    public ResponseEntity<Void> createProducts(@RequestBody List<ProductLoad> products, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint createProducts : was hit at: " + DATEUTIL.getTime() + " by : ",
                ProductController.class);
        productService.createBatchProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-categories")
    public ResponseEntity<Void> createCategories(@RequestBody List<Category> products, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint createCategories : was hit at: " + DATEUTIL.getTime() + " by : ",
                ProductController.class);
        productService.createBatchCategories(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

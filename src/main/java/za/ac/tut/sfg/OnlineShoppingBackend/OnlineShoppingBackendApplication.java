package za.ac.tut.sfg.OnlineShoppingBackend;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import za.ac.tut.sfg.OnlineShoppingBackend.gettingonlinedata.Category;
import za.ac.tut.sfg.OnlineShoppingBackend.gettingonlinedata.ProductLoad;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.LoggerUtil;

@SpringBootApplication
public class OnlineShoppingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingBackendApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            List<Category> countries = (List<Category>) restTemplate.getForObject(
//                    "https://api.escuelajs.co/api/v1/categories", Category.class);
//            new LoggerUtil().LOG_INFO(countries.toString(), OnlineShoppingBackendApplication.class);
//            
//            List<ProductLoad> productLoads = (List<ProductLoad>) restTemplate.getForObject(
//                    "https://api.escuelajs.co/api/v1/categories", ProductLoad.class);
//            new LoggerUtil().LOG_INFO(productLoads.toString(), OnlineShoppingBackendApplication.class);
//        };
//    }
}

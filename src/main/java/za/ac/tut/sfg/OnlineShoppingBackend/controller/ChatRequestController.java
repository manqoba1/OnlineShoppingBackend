/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ShopCartDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer.ResponseDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.service.OrderProcessingService;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.DateUtil;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.LoggerUtil;

/**
 *
 * @author sifis
 */
@RestController
@RequestMapping(value = "/api/v1/chat")
public class ChatRequestController {

    LoggerUtil LOGGER = new LoggerUtil();
    DateUtil DATEUTIL = new DateUtil();

    @Autowired
    public OrderProcessingService orderProcessingService;

    @PostMapping("/customerSendsRecommendationRequest")
    public ResponseEntity<ResponseDTO> customerSendsRecommendationRequest(@PathVariable String user_uid, @PathVariable String stylist_uid, @PathVariable String message, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint customerSendsRecommendationRequest : was hit at: " + DATEUTIL.getTime() + " by : ",
                ProductController.class);
        ResponseDTO dto = new ResponseDTO();
//        dto.setPurchasedOrder(orderProcessingService.sendCustomerRecommendation(products));
//        dto.setMessage("Recommendation Saved");
//        dto.setPurchasedOrder(products);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/stylistAcceptOrDenyRecommendationRequest")
    public ResponseEntity<ResponseDTO> stylistAcceptOrDenyRecommendationRequest(@PathVariable String user_uid, @PathVariable String stylist_uid, @PathVariable int status, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint stylistAcceptOrDenyRecommendationRequest : was hit at: " + DATEUTIL.getTime() + " by : ",
                ProductController.class);
        ResponseDTO dto = new ResponseDTO();
//        dto.setPurchasedOrder(orderProcessingService.customerApprovesRecommendation(products));
//        dto.setMessage("Recommendation Approved By Customer");

//        dto.setPurchasedOrder(products);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

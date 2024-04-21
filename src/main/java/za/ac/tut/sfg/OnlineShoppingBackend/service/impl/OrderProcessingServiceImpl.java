/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ShopCartDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.ShopCartItemDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer.ResponseDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcart;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Shopcartitem;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.OrderProcessingRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.ProductRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.ShopcartItemRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.UserRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.service.OrderProcessingService;

/**
 *
 * @author sifis
 */
@RequiredArgsConstructor
@Service
public class OrderProcessingServiceImpl implements OrderProcessingService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public OrderProcessingRepository orderProcessingRepository;
    @Autowired
    public ShopcartItemRepository shopcartItemRepository;

    @Override
    public ShopCartDTO sendCustomerRecommendation(ShopCartDTO products) {
        Shopcart s = new Shopcart();
        s.setDiscount(products.getDiscount());
        s.setOrderDate(products.getOrderDate());
        s.setOrderId(products.getOrderId());
        s.setOrderStatusId(products.getOrderStatusId());
        s.setStylistUid(products.getStylistUid());
        s.setUserUid(products.getUserUid());
        s.setTotalAmout(products.getTotalAmout());
        s.setUserId(userRepository.getUserByUid(products.getUserUid()).get());
        s = orderProcessingRepository.saveAndFlush(s);
        List<ShopCartItemDTO> shopcartitems = new ArrayList<>();
        for (ShopCartItemDTO p : products.getOrderItems()) {
            Shopcartitem shopcart = new Shopcartitem();
            shopcart.setOrderId(p.getOrderId());
            shopcart.setComments(p.getComments());
            shopcart.setOrderItemStatus(p.getOrderItemStatus());
            shopcart.setQuantity(p.getQuantity());
            shopcart.setProductId(productRepository.findProductById(p.getId()));
            shopcart.setShopcartId(s);
            shopcart = shopcartItemRepository.saveAndFlush(shopcart);
            shopcartitems.add(new ShopCartItemDTO(shopcart));
        }
        products = new ShopCartDTO(s);
        products.setOrderItems(shopcartitems);
        return products;
    }

    @Override
    public ShopCartDTO customerApprovesRecommendation(ShopCartDTO products) {

        Shopcart s = new Shopcart();
        s.setDiscount(products.getDiscount());
        s.setOrderDate(products.getOrderDate());
        s.setOrderId(products.getOrderId());
        s.setOrderStatusId(products.getOrderStatusId());
        s.setStylistUid(products.getStylistUid());
        s.setUserUid(products.getUserUid());
        s.setTotalAmout(products.getTotalAmout());
        s.setUserId(userRepository.getUserByUid(products.getUserUid()).get());
        s = orderProcessingRepository.saveAndFlush(s);
        List<ShopCartItemDTO> shopcartitems = new ArrayList<>();
        for (ShopCartItemDTO p : products.getOrderItems()) {
            Shopcartitem shopcart = new Shopcartitem();
            shopcart.setOrderId(p.getOrderId());
            shopcart.setComments(p.getComments());
            shopcart.setOrderItemStatus(p.getOrderItemStatus());
            shopcart.setQuantity(p.getQuantity());
            shopcart.setProductId(productRepository.findProductById(p.getId()));
            shopcart.setShopcartId(s);
            shopcart = shopcartItemRepository.saveAndFlush(shopcart);
            shopcartitems.add(new ShopCartItemDTO(shopcart));
        }
        products = new ShopCartDTO(s);
        products.setOrderItems(shopcartitems);

        return products;
    }

    @Override
    public ResponseDTO stylistAcceptOrDenyRecommendation(String userUid, String stylistUid, int status) {
        ResponseDTO dto = new ResponseDTO();
//        for (ShopCartItemDTO p : products.getOrderItems()) {
//
//        }
        return dto;
    }

}

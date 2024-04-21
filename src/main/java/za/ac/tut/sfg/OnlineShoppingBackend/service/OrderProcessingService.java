/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.service;

import za.ac.tut.sfg.OnlineShoppingBackend.dto.ShopCartDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer.ResponseDTO;

/**
 *
 * @author sifis
 */

public interface OrderProcessingService {

    ShopCartDTO sendCustomerRecommendation(ShopCartDTO products);

    ShopCartDTO customerApprovesRecommendation(ShopCartDTO products);

    ResponseDTO stylistAcceptOrDenyRecommendation(String userUid, String stylistUid, int status);
}

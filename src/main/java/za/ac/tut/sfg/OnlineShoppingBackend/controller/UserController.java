/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sifis
 */
@RestController
@RequestMapping(value = "/user/v1")
public class UserController {
      @GetMapping(value = "/health-check")
    public String getHeaders(@RequestHeader Map<String, String> headers) {
//          System.Logger.LOG_INFO("/health-check: was hit at: "+ System.currentTimeMillis()  +" by :", UserController.class);
//        headers.forEach((key, value) -> {
//            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
//        });
        return "We are pumping!";
    }
}

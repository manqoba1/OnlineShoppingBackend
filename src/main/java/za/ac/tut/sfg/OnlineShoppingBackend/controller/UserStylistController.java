/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.transfer.ResponseDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.exceptions.UserException;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;
import za.ac.tut.sfg.OnlineShoppingBackend.service.ProductService;
import za.ac.tut.sfg.OnlineShoppingBackend.service.UserStylistService;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.DateUtil;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.LoggerUtil;

/**
 *
 * @author sifis
 */
@RestController
@RequestMapping(value = "/api/v1/user-stylist")
public class UserStylistController {

    LoggerUtil LOGGER = new LoggerUtil();
    DateUtil DATEUTIL = new DateUtil();

    @Autowired
    public UserStylistService userStylistService;
    @Autowired
    public ProductService productService;

    @GetMapping(value = "/health-check")
    public String getHeaders(@RequestHeader Map<String, String> headers) {
//          System.Logger.LOG_INFO("/health-check: was hit at: "+ System.currentTimeMillis()  +" by :", UserController.class);
//        headers.forEach((key, value) -> {
//            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
//        });
        return "We are pumping!";
    }

    @GetMapping("/user/login/{email}/{password}")
    public ResponseEntity<ResponseDTO> loginUser(@PathVariable String email, @PathVariable String password) {
        ResponseDTO response = new ResponseDTO();
        try {
            LOGGER.LOG_INFO("Endpoint /user/login : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
            UserDTO savedUser = userStylistService.loginUser(email, password);

            if (savedUser != null) {
                if (savedUser.getUserRoleId() == 1) {
                    response.setUsers(userStylistService.getActiveStylist("online", 2));
                }
                response.setProducts(productService.findAllProduct());
//                response.setCategories(productService.findAllCategories());
                response.setUser(savedUser);
                LOGGER.LOG_INFO("Endpoint /user/login : was hit at: user found" + DATEUTIL.getTime() + " by : ", UserStylistController.class);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            LOGGER.LOG_INFO("Endpoint /user/login : was hit at: user not found" + DATEUTIL.getTime() + " by : ", UserStylistController.class);
            response.setMessage("user not found");
            response.setStatusCode(804);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.setMessage("user not found");
        response.setStatusCode(804);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/user/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO user) {
        LOGGER.LOG_INFO("Endpoint /user/create : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        UserDTO savedUser = userStylistService.createUser(user);
        ResponseDTO response = new ResponseDTO();
        if (savedUser != null && user.getUserRoleId() == 1) {
            response.setUsers(userStylistService.getActiveStylist("online", 2));
        }
//        response.setCategories(productService.findAllCategories());
        response.setProducts(productService.findAllProduct());
        response.setUser(savedUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/user/find-active-stylist/{status}")
    public ResponseEntity<ResponseDTO> getActiveStylist(@PathVariable String status, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint getActiveStylist : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        List<UserDTO> t = userStylistService.getActiveStylist(status, 2);
        ResponseDTO response = new ResponseDTO();
        response.setStylists(t);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//
//    @GetMapping("/")
//    public ResponseEntity<List<Task>> getTaskList() {
//        List<Task> taskList = taskService.getAllTasks();
//        LOGGER.LOG_INFO(" getTaskList count :::::>> " + taskList.size(), TaskController.class);
//        return new ResponseEntity<>(taskList, HttpStatus.OK);
//    }

    @PutMapping("/user/update")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO user, @RequestHeader Map<String, String> headers) {
        ResponseDTO response = new ResponseDTO();
        LOGGER.LOG_INFO("Endpoint updateUser : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        headers.forEach((key, value) -> {
            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), UserStylistController.class);
        });
        UserDTO updatedUser = userStylistService.updateUser(user);
        response.setUser(updatedUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//
//    @GetMapping("remove/{id}")
//    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long taskId, @RequestHeader Map<String, String> headers) {
//        LOGGER.LOG_INFO("Endpoint deleteTaskById : was hit at: " + DATEUTIL.getTime() + " by : ", TaskController.class);
//        headers.forEach((key, value) -> {
//            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
//        });
//        taskService.deleteTask(taskId);
//        return new ResponseEntity<>("Deleted for good!", HttpStatus.OK);
//    }
}

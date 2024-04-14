/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.controller;

import java.util.ArrayList;
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
import za.ac.tut.sfg.OnlineShoppingBackend.exceptions.UserException;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Stylist;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;
import za.ac.tut.sfg.OnlineShoppingBackend.service.UserStylistService;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.DateUtil;
import za.ac.tut.sfg.OnlineShoppingBackend.utils.LoggerUtil;

/**
 *
 * @author sifis
 */
@RestController
@RequestMapping(value = "/user-stylist/v1")
public class UserStylistController {

    LoggerUtil LOGGER = new LoggerUtil();
    DateUtil DATEUTIL = new DateUtil();

    @Autowired
    public UserStylistService userStylistService;

    @GetMapping(value = "/health-check")
    public String getHeaders(@RequestHeader Map<String, String> headers) {
//          System.Logger.LOG_INFO("/health-check: was hit at: "+ System.currentTimeMillis()  +" by :", UserController.class);
//        headers.forEach((key, value) -> {
//            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), TaskController.class);
//        });
        return "We are pumping!";
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        LOGGER.LOG_INFO("Endpoint /create/user/ : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        Optional<User> savedUser = userStylistService.createUser(user);
        return new ResponseEntity<>(savedUser.get(), HttpStatus.CREATED);
    }

    @PostMapping("/stylist/create")
    public ResponseEntity<Stylist> createStylist(@RequestBody Stylist stylist) {
        LOGGER.LOG_INFO("Endpoint /create/stylist/ : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        Optional<Stylist> savedStylist = userStylistService.createStylist(stylist);
        return new ResponseEntity<>(savedStylist.get(), HttpStatus.CREATED);
    }

    @GetMapping("/user/login/{email}/{password}")
    public ResponseEntity<User> loginUser(@PathVariable("email") String email, @PathVariable("password") String password, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint getTaskById : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);

        return userStylistService.loginUser(email, password).
                map(user -> {
                    user.setChatList(new ArrayList<>()); // populate later
                    user.setChatlistList(new ArrayList<>()); // populate later
                    user.setShopcartList(new ArrayList<>()); // populate later
                    return ResponseEntity.ok(user);
                }).
                orElseThrow(() -> new UserException("Invalid User details"));
    }

    @GetMapping("/stylist/login/{email}/{password}")
    public ResponseEntity<Stylist> loginStylist(@PathVariable("email") String email, @PathVariable("password") String password, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint getTaskById : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);

        return userStylistService.loginStylist(email, password).
                map(user -> {
                    user.setChatList(new ArrayList<>()); // populate later
                    user.setChatlistList(new ArrayList<>()); // populate later
                    user.setShopcartList(new ArrayList<>()); // populate later
                    return ResponseEntity.ok(user);
                }).
                orElseThrow(() -> new UserException("Invalid User details"));
    }

    @GetMapping("/stylist/{status}")
    public ResponseEntity<List<Stylist>> getActiveStylist(@PathVariable("status") String status, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint getActiveStylist : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        Optional<List<Stylist>> t = userStylistService.getActiveStylist(status);

        return new ResponseEntity<>(t.get(), HttpStatus.OK);
    }
//
//    @GetMapping("/")
//    public ResponseEntity<List<Task>> getTaskList() {
//        List<Task> taskList = taskService.getAllTasks();
//        LOGGER.LOG_INFO(" getTaskList count :::::>> " + taskList.size(), TaskController.class);
//        return new ResponseEntity<>(taskList, HttpStatus.OK);
//    }

    @PostMapping("/user/update")
    public ResponseEntity<User> updateUser(@RequestBody User user, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint updateUser : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        headers.forEach((key, value) -> {
            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), UserStylistController.class);
        });
        Optional<User> updatedUser = userStylistService.updateUser(user);
        return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
    }

    @PostMapping("/stylist/update")
    public ResponseEntity<Stylist> updateStylist(@RequestBody Stylist user, @RequestHeader Map<String, String> headers) {
        LOGGER.LOG_INFO("Endpoint updateStylist : was hit at: " + DATEUTIL.getTime() + " by : ", UserStylistController.class);
        headers.forEach((key, value) -> {
            LOGGER.LOG_INFO((String.format("Header '%s' = %s", key, value)), UserStylistController.class);
        });
        Optional<Stylist> updatedUser = userStylistService.updateStylist(user);
        return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
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

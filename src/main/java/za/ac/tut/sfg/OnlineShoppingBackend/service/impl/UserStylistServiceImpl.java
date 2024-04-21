/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.dto.UserRoleDTO;
import za.ac.tut.sfg.OnlineShoppingBackend.exceptions.UserException;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.UserRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.UserRoleRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.service.UserStylistService;

/**
 *
 * @author sifis
 */
@RequiredArgsConstructor
@Service
public class UserStylistServiceImpl implements UserStylistService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    public UserDTO loginUser(String email, String password) throws NoSuchElementException {
        User optionalUser = userRepository.login(email, password).get();
        return new UserDTO(optionalUser);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
//        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreCase("email");
//        Example<User> example = Example.of(user,
//                caseInsensitiveExampleMatcher);

        long actual = userRepository.userExist(user.getEmail());
        if (actual > 0) {
            throw new UserException("User " + user.getEmail() + " exists");
//            actual.orElseThrow(() -> new UserException("User " + user.getEmail() + " exists"));
        }
//        UserProfile currentUserProfile = user.getUserProfile();
//        List<Address> addressSet = addressRepository.saveAll(user.getUserProfile().getAddresses());
//        currentUserProfile.getAddresses().addAll(addressSet);
        User current = new User();
        current.setName(user.getName());
        current.setSurname(user.getSurname());
        current.setActiveStatus("online");
        current.setCell(user.getCell());
//        current.setDob(new Date(user.getDob()));
        current.setImageUrl(user.getImageUrl());
        current.setUserUid(user.getUserUid());
        current.setPassword(user.getPassword());
        current.setSurname(user.getSurname());
        current.setEmail(user.getEmail());
        current.setSurname(user.getSurname());
        current.setUserroleId(roleRepository.findById(user.getUserRoleId()).get());
        current = userRepository.save(current);
        return Optional.ofNullable(new UserDTO(current)).get();
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return Optional.ofNullable(new UserDTO(userRepository.findById(userId).get())).get();
    }

    @Override
    public UserDTO getUserByUid(String userUid) {
        return Optional.ofNullable(new UserDTO(userRepository.getUserByUid(userUid).get())).get();
    }

    @Override
    public List<UserDTO> getActiveStylist(String activeStatus, int userroleId) {
        List<UserDTO> response = new ArrayList<>();
        Optional<List<User>> activeStylists = Optional.ofNullable(getActiveStylists(activeStatus, userroleId));
//        Optional<List<User>> users = 
        for (User u : activeStylists.get()) {
            response.add(new UserDTO(u));
        }

        return Optional.ofNullable(response).get();
    }

    private List<User> getActiveStylists(String activeStatus, int userroleId) {
        return userRepository.findStylistByActiveStatus(activeStatus, userroleId).get();
    }

    @Transactional
    @Override
    public UserDTO updateUser(UserDTO user) {

        return userRepository.findById(user.getId()).map(current -> {
            current.setName(user.getName());
            current.setSurname(user.getSurname());
            current.setActiveStatus(user.getActiveStatus());
            current.setCell(user.getCell());
            current.setDob(new Date(user.getDob()));
            current.setImageUrl(user.getImageUrl());
            current.setUserUid(user.getUserUid());
            current.setPassword(user.getPassword());
            current.setSurname(user.getSurname());
            current.setUserroleId(roleRepository.findById(user.getUserRoleId()).get());
//            current.setAddresses(user.getAddresses());

            return Optional.ofNullable(new UserDTO(current));
        }).orElseThrow(() -> new UserException("User " + user.getEmail() + " does not exists")).get();
    }

    @Override
    public UserRoleDTO getUserRole(Integer userRoleId) {
        return new UserRoleDTO(roleRepository.findById(userRoleId).get());
    }
}

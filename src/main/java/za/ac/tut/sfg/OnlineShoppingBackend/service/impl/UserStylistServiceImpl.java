/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.sfg.OnlineShoppingBackend.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.tut.sfg.OnlineShoppingBackend.exceptions.UserException;
import za.ac.tut.sfg.OnlineShoppingBackend.model.Stylist;
import za.ac.tut.sfg.OnlineShoppingBackend.model.User;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.StylistRepository;
import za.ac.tut.sfg.OnlineShoppingBackend.repository.UserRepository;
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
    private StylistRepository stylistRepository;

    @Override
    public Optional<User> loginUser(String email, String password) {
        return userRepository.login(email, password);
    }

    @Override
    public Optional<Stylist> loginStylist(String email, String password) {
        return stylistRepository.login(email, password);
    }

    @Override
    public Optional<User> createUser(User user) {
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreCase("email");
        Example<User> example = Example.of(user,
                caseInsensitiveExampleMatcher);

        long actual = userRepository.userExist(user.getEmail());
        if (actual > 0) {
            throw new UserException("User " + user.getEmail() + " exists");
//            actual.orElseThrow(() -> new UserException("User " + user.getEmail() + " exists"));
        }
//        UserProfile currentUserProfile = user.getUserProfile();
//        List<Address> addressSet = addressRepository.saveAll(user.getUserProfile().getAddresses());
//        currentUserProfile.getAddresses().addAll(addressSet);
        return Optional.of(user);
    }

    @Override
    public Optional<Stylist> createStylist(Stylist stylist) {
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreCase("email");
        Example<Stylist> example = Example.of(stylist,
                caseInsensitiveExampleMatcher);

        long actual = userRepository.userExist(stylist.getEmail());
        if (actual > 0) {
            throw new UserException("User " + stylist.getEmail() + " exists");
//            actual.orElseThrow(() -> new UserException("User " + user.getEmail() + " exists"));
        }

//        UserProfile currentUserProfile = user.getUserProfile();
//        List<Address> addressSet = addressRepository.saveAll(user.getUserProfile().getAddresses());
//        currentUserProfile.getAddresses().addAll(addressSet);
        return Optional.of(stylist);
    }

    @Override
    public Optional<Stylist> getStylistById(Integer stylistId) {
        return stylistRepository.findById(stylistId);
    }

    @Override
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<Stylist> getStylistByUid(String stylistUid) {
        return stylistRepository.getStylistByUid(stylistUid);
    }

    @Override
    public Optional<?> getUserByUid(String userUid) {
        return userRepository.getUserByUid(userUid);
    }

    @Override
    public Optional<List<Stylist>> getActiveStylist(String status) {
        return stylistRepository.findStylistByActiveStatus(status);
    }

    @Transactional
    @Override
    public Optional<User> updateUser(User user) {

        return userRepository.findById(user.getId()).map(current -> {
            current.setName(user.getName());
            current.setSurname(user.getSurname());
            current.setActiveStatus(user.getActiveStatus());
            current.setCell(user.getCell());
            current.setDob(user.getDob());
            current.setImageUrl(user.getImageUrl());
            current.setUserUid(user.getUserUid());
            current.setPassword(user.getPassword());
            current.setSurname(user.getSurname());

            return Optional.of(current);
        }).orElseThrow(() -> new UserException("User " + user.getEmail() + " does not exists"));
    }

    @Transactional
    @Override
    public Optional<Stylist> updateStylist(Stylist stylist) {
        return stylistRepository.findById(stylist.getId()).map(current -> {
            current.setName(stylist.getName());
            current.setSurname(stylist.getSurname());
            current.setActiveStatus(stylist.getActiveStatus());
            current.setCell(stylist.getCell());
            current.setDob(stylist.getDob());
            current.setImageUrl(stylist.getImageUrl());
            current.setStylistUid(stylist.getStylistUid());
            current.setPassword(stylist.getPassword());
            current.setSurname(stylist.getSurname());

            return Optional.of(current);
        }).orElseThrow(() -> new UserException("User " + stylist.getEmail() + " does not exists"));
    }

}

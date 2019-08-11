package com.market.api.service;

import com.market.api.entity.User;
import com.market.api.exception.UserAlreadyExists;
import com.market.api.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUser(Long id) throws UserNotFoundException;

    User addUser(User user) throws UserAlreadyExists;

    void deleteUserById(Long id) throws UserNotFoundException;

    User updateUser(User user, Long id);

}

package com.market.api.service;

import com.market.api.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUser(Long id);

    User addUser(User user);

    void deleteUserById(Long id);

    User updateUser(User user, Long id);

}

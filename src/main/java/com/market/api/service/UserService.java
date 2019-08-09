package com.market.api.service;

import com.market.api.entity.User;
import com.market.api.exception.UserNotFoundException;
import com.market.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) throws UserNotFoundException {
        Optional<User> targetUser = userRepository.findById(id);

        if( targetUser.isPresent() )
        {
            return targetUser.get();
        }
        else
        {
            throw new UserNotFoundException("User [" + id + "] doesn't exist.");
        }
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {

        Optional<User> targetUser = userRepository.findById(id);

        if( targetUser.isPresent() )
        {
            User user = targetUser.get();
            userRepository.delete(user);
        }
        else
        {
           throw new UserNotFoundException("User [" + id + "] doesn't exist.");
        }

    }

    @Override
    public User updateUser(User user, Long id) {
        user.setUserId(id);
        return userRepository.save(user);
    }
}

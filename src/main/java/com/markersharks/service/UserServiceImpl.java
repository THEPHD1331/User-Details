package com.markersharks.service;

import com.markersharks.entity.User;
import com.markersharks.exception.InvalidUserException;
import com.markersharks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Override
    public User registerUser(User user) throws InvalidUserException {
        if (user == null) {
            throw new InvalidUserException("Error - User is Null!");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) throws InvalidUserException {
        if (username == null) {
            throw new InvalidUserException("Error - Username is Null!");
        } else if (userRepository.findByUsername(username) == null) {
            throw new InvalidUserException("Error - User " + username + " does not exist!");
        }
        return userRepository.findByUsername(username);
    }
}

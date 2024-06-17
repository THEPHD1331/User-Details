package com.markersharks.service;

import com.markersharks.entity.User;
import com.markersharks.exception.InvalidUserException;

public interface UserService {

    User registerUser(User user) throws InvalidUserException;
    User getUserByUsername(String username) throws InvalidUserException;
}

package com.markersharks.service;

import com.markersharks.entity.User;
import com.markersharks.exception.InvalidUserException;
import com.markersharks.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void registerUserTest() throws InvalidUserException {

        User user = new User();
        user.setUserId(1);
        user.setUsername("Akash");
        user.setEmail("akash@gmail.com");
        user.setPassword("akash345");

        when(userRepository.save(any())).thenReturn(user);
        User user1 = userService.registerUser(user);
        assertEquals("Akash", user1.getUsername());
    }

    @Test
    public void getUserByUsernameTest() throws InvalidUserException {

        User user = new User();
        user.setUserId(2);
        user.setUsername("Raj");
        user.setEmail("raj@gmail.com");
        user.setPassword("raj789");

        when(userRepository.findByUsername(anyString())).thenReturn(user);
        User user1 = userService.getUserByUsername("Raj");
        assertEquals(user.getUsername(), user1.getUsername());
    }

    @Test(expected = InvalidUserException.class)
    public void getUserByUsernameNullTest() throws InvalidUserException {

        User user = null;
        when(userRepository.findByUsername(anyString())).thenReturn(user);

        User user1 = userService.getUserByUsername("");
        assertNull(user1);
    }

    @Test(expected = InvalidUserException.class)
    public void registerUserNullTest() throws InvalidUserException {

        User user = null;

        User user1 = userService.registerUser(user);
        assertNull(user1);
    }
}

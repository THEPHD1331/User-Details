package com.markersharks.controller;

import com.markersharks.entity.User;
import com.markersharks.exception.InvalidUserException;
import com.markersharks.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping("/register")
    ResponseEntity<String> registerUser(@RequestBody User user) {
        User user1;
        try {
            user1 = userService.registerUser(user);
        } catch (InvalidUserException invalidUser) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("User Registered Successfully!", HttpStatus.OK);
    }

    @GetMapping("/fetch")
    ResponseEntity<User> getUserByUsername(@RequestParam String username) throws InvalidUserException {
        if (StringUtils.isEmpty(username)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = userService.getUserByUsername(username);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

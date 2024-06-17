package com.markersharks.controller;

import com.markersharks.entity.User;
import com.markersharks.exception.InvalidUserException;
import com.markersharks.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void testRegisterUser() throws Exception {

        User user = new User();
        user.setUserId(1);
        user.setUsername("Akash");
        user.setEmail("akash@gmail.com");
        user.setPassword("akash345");

        when(userService.registerUser(any())).thenReturn(user);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/register")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void testGetUserByUsername() throws Exception {

        User user = new User();
        user.setUserId(2);
        user.setUsername("Raj");
        user.setEmail("raj@gmail.com");
        user.setPassword("raj789");

        when(userService.getUserByUsername(anyString())).thenReturn(user);
        RequestBuilder builder = MockMvcRequestBuilders.get("/api/user/fetch?username=Raj")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void testGetUserByUsernameNull() throws Exception{
        when(userService.getUserByUsername(anyString())).thenThrow(new NullPointerException());
        RequestBuilder builder= MockMvcRequestBuilders.get("/api/user/fetch?username=")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder).andExpect(status().isBadRequest());
    }

    @Test
    public void testRegisterUserNotFound() throws Exception{
        when(userService.registerUser(any())).thenThrow(new InvalidUserException("User details not entered"));
        RequestBuilder builder= MockMvcRequestBuilders.post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder).andExpect(status().isBadRequest());
    }

    public String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

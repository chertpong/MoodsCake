package com.kritacademy.projects.controller;

/**
 * Created by Chertpong on 19/11/2558.
 */

import com.kritacademy.projects.MoodsCakeApplication;
import com.kritacademy.projects.repository.CakeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoodsCakeApplication.class)
@WebAppConfiguration
public class OrderControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAddOrder() throws Exception {
        this.mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
//        {
//            name:"Krit",
//                    phoneNumber:"0877772222",
//                allergic:"No",
//                specialNeed:"HBD",
//                pickupDate:"2015-12-1",
//                cake:{
//
//        },
//            size:1.0,
//                    topping:[
//            "Strawberries"
//            ]
//        }
    }

    @Test
    public void testGetAllOrder() throws Exception {
        this.mockMvc.perform(get("/orders").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].id").value(1));

    }
}

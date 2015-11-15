package com.kritacademy.projects.controller;

import com.kritacademy.projects.entity.OrderHistory;
import com.kritacademy.projects.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Chertpong on 14/11/2558.
 */
@RestController
public class OrderHistoryController {
    @Autowired
    OrderHistoryService orderHistoryService;

    @RequestMapping(value = "/ordersHistory",method = RequestMethod.GET)
    public List<OrderHistory> getAll(){
        return orderHistoryService.getAll();
    }
}

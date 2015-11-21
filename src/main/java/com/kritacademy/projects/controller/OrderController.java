package com.kritacademy.projects.controller;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.entity.Order;
import com.kritacademy.projects.entity.OrderStatus;
import com.kritacademy.projects.service.CakeService;
import com.kritacademy.projects.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chertpong on 14/11/2558.
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CakeService cakeService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAll(){
        return orderService.getAll();
    }
    @RequestMapping(value = "/orders/{id}",method = RequestMethod.GET)
    public Order getById(@PathVariable("id") Long id){
        return orderService.getById(id);
    }
    @RequestMapping(value = "/orders/cake/{cid}/status/{sid}", method = RequestMethod.POST)
    public Order addOrder(@Validated @RequestBody Order order, @PathVariable("cid") Long cid, @PathVariable("sid") int sid){
        return orderService.addOrder(order,cid,sid);
    }
    @RequestMapping(value = "/orders/", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order){

        return orderService.updateOrder(order);
    }
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public boolean deleteOrder(@PathVariable("id") Long id){
        return orderService.deleteOrder(id);
    }
}

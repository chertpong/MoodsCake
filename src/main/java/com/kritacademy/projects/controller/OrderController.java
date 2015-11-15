package com.kritacademy.projects.controller;

import com.kritacademy.projects.entity.Order;
import com.kritacademy.projects.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Chertpong on 14/11/2558.
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAll(){
        return orderService.getAll();
    }
    @RequestMapping(value = "/orders/{id}",method = RequestMethod.GET)
    public Order getById(@PathVariable("id") Long id){
        return orderService.getById(id);
    }
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @RequestMapping(value = "/orders/", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public boolean deleteOrder(@RequestParam("id") Long id){
        return orderService.deleteOrder(id);
    }
}

package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Order;

import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
public interface OrderService {
    public List<Order> getAll();
    public Order getById(Long id);
    public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public boolean deleteOrder(Long id);
}
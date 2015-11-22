package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Order;

import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
public interface OrderService {
    public List<Order> getAll();
    public Order getById(Long id);
    public Order addOrder(Order order,Long cakeId, int statusId);
    public Order updateOrder(Order order,Long cakeId, int statusId);
    public boolean deleteOrder(Long id);
    public void reset();
}

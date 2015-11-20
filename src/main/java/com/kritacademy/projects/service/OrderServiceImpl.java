package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Order;
import com.kritacademy.projects.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Transactional
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Transactional
    @Override
    public Order getById(Long id) {
        return orderRepository.findOne(id);
    }

    @Transactional
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public boolean deleteOrder(Long id) {
        Order order = getById(id);
        orderRepository.delete(order);
        return true;
    }
}

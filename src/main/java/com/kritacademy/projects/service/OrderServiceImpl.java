package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.entity.Order;
import com.kritacademy.projects.entity.OrderStatus;
import com.kritacademy.projects.repository.CakeRepository;
import com.kritacademy.projects.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CakeRepository cakeRepository;

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
    public Order addOrder(Order order,Long cakeId, int statusId) {
        List<OrderStatus> orderStatusList = Arrays.asList(
                OrderStatus.Pending,
                OrderStatus.Accepted,
                OrderStatus.ReadyToServe,
                OrderStatus.Received,
                OrderStatus.Canceled
        );
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Bangkok"));
        Cake cake = cakeRepository.findOne(cakeId);
        order.setCake(cake);
        order.setStatus(orderStatusList.get(statusId));
        if(now.isAfter(LocalDateTime.ofInstant(order.getPickupDate().toInstant(), ZoneId.of("Asia/Bangkok")))){
            throw new RuntimeException("Date of pickup must not be in past");
        }

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

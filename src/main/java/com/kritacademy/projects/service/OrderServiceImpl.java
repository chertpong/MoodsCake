package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.entity.Order;
import com.kritacademy.projects.entity.OrderStatus;
import com.kritacademy.projects.exception.CakeNotFound;
import com.kritacademy.projects.exception.DateIsInvalidException;
import com.kritacademy.projects.exception.OrderNotFoundException;
import com.kritacademy.projects.exception.OrderStatusNotFound;
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
        return orderRepository.save(validateOrder(order,cakeId,statusId));
    }
    @Transactional
    @Override
    public Order updateOrder(Order order, Long cakeId, int statusId) {
        if(orderRepository.findOne(order.getId())== null){
            throw new OrderNotFoundException("Order is not found, the id may be invalid");
        }
        return orderRepository.save(validateOrder(order,cakeId,statusId));
    }

    @Transactional
    @Override
    public boolean deleteOrder(Long id) {
        Order order = getById(id);
        orderRepository.delete(order);
        return true;
    }

    private Order validateOrder(Order order,Long cakeId, int statusId){
        List<OrderStatus> orderStatusList = Arrays.asList(
                OrderStatus.Pending,
                OrderStatus.Accepted,
                OrderStatus.ReadyToServe,
                OrderStatus.Received,
                OrderStatus.Canceled
        );
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Bangkok"));
        try {
            if(now.isAfter(LocalDateTime.ofInstant(order.getPickupDate().toInstant(), ZoneId.of("Asia/Bangkok")))){
                throw new DateIsInvalidException("Date of pickup must not be in past");
            }

            Cake cake = cakeRepository.findOne(cakeId);

            if(cake == null){throw new CakeNotFound("Cake is not found");}

            order.setCake(cake);
            order.setStatus(orderStatusList.get(statusId));
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new OrderStatusNotFound("Order status not found");
        }
        return order;

    }

}

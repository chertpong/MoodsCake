package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.OrderHistory;
import com.kritacademy.projects.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chertpong on 13/11/2558.
 */
@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Transactional
    @Override
    public List<OrderHistory> getAll() {
        return orderHistoryRepository.findAll();
    }
}

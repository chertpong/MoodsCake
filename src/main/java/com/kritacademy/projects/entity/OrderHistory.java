package com.kritacademy.projects.entity;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Entity
public class OrderHistory extends Order {
    public OrderHistory() {
    }

    public OrderHistory(Long id, String name, String phoneNumber, String allergic, String specialNeed, Date pickupDate, Cake cake, Double size, List<Topping> topping, OrderStatus status) {
        super(id, name, phoneNumber, allergic, specialNeed, pickupDate, cake, size, topping, status);
    }
}

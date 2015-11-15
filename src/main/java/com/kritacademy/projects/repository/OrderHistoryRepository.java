package com.kritacademy.projects.repository;

import com.kritacademy.projects.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
}

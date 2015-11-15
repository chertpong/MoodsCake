package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Cake;

import java.util.List;

/**
 * Created by Chertpong on 12/11/2558.
 */
public interface CakeService {
    public List<Cake> getAll();
    public Cake getById(Long id);
    public List<Cake> getRandomCakeUnique(int number);
}

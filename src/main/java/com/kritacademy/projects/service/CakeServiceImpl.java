package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Chertpong on 12/11/2558.
 */
@Service
public class CakeServiceImpl implements CakeService {
    @Autowired
    CakeRepository cakeRepository;

    @Transactional
    @Override
    public List<Cake> getAll() {
        return cakeRepository.findAll();
    }

    @Transactional
    @Override
    public Cake getById(Long id) {
        return cakeRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Cake> getRandomCakeUnique(int number) {
        List<Cake> cakes = getAll();
        List<Cake> selectedCake = new ArrayList<>(number);
        Set<Integer> randomNumber = new HashSet<>();
        while (randomNumber.size()<number){
            randomNumber.add(((int) (Math.random()*cakes.size())));
        }
        randomNumber.forEach(n ->{
            selectedCake.add(cakes.get(n));
        });
        return selectedCake;
    }
}

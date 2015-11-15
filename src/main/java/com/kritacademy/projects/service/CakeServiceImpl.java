package com.kritacademy.projects.service;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        for(int i = 0; i<number;i++){
            int randomNumber = (int)+Math.random()*cakes.size();
            selectedCake.add(cakes.get(randomNumber));
            cakes.remove(randomNumber);
        }
        return selectedCake;
    }
}

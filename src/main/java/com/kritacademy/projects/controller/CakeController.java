package com.kritacademy.projects.controller;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Chertpong on 14/11/2558.
 */
@RestController
public class CakeController {
    @Autowired
    CakeService cakeService;

    @RequestMapping(value = "/cakes", method = RequestMethod.GET)
    public List<Cake> getAll(){
        return cakeService.getAll();
    }
    @RequestMapping(value = "/cakes/{id}",method = RequestMethod.GET)
    public Cake getById(@PathVariable("id") Long id){
        return cakeService.getById(id);
    }
    @RequestMapping(value = "/cakes/random/{number}/unique", method = RequestMethod.GET)
    public List<Cake> getRandomCakeUnique(@PathVariable("number") int number){
        return cakeService.getRandomCakeUnique(number);
    }
}

package com.kritacademy.projects.init;

import com.kritacademy.projects.entity.Cake;
import com.kritacademy.projects.entity.Topping;
import com.kritacademy.projects.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chertpong on 19/11/2558.
 */
@Profile("dev")
@Component
public class CakeInit implements CommandLineRunner{
    @Autowired
    private CakeRepository cakeRepository;

    @Override
    public void run(String... strings) throws Exception {
//        stub data
//        stub cake data
        cakeRepository.save(new Cake("Chocolate Cake",850.00,"No Description",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
                "http://hydrogen01.cloudapp.net/moods/img/chocolate.jpg")
        );

        cakeRepository.save(new Cake("Strawberry Shortcake",850.00,"No Description",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
                "http://hydrogen01.cloudapp.net/moods/img/stawberry.jpg")
        );

        cakeRepository.save(new Cake("Cheese Cake",900.00,"No Description",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
                "http://hydrogen01.cloudapp.net/moods/img/cheese.jpg")
        );

        cakeRepository.save(new Cake("Tiramisu Cake",800.00,"No Description",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
                "http://hydrogen01.cloudapp.net/moods/img/tiramisu.jpg")
        );

        cakeRepository.save(new Cake("Banoffee",800.00,"No Description",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
                "http://hydrogen01.cloudapp.net/moods/img/banoffee.jpg")
        );

    }
}

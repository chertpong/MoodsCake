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
        cakeRepository.save(new Cake("Chocolate Cake - 3 Layer",850.00,"No Description",
        (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
        "http://wisebarbecue.com/wp-content/uploads/2015/02/Prize-Winning-Chocolate-Cake-6inch_2.jpg")
        );
        
        cakeRepository.save(new Cake("Strawberry Shortcake - 3 Layer",850.00,"No Description",
        (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
        "https://scontent-sin1-1.xx.fbcdn.net/hphotos-xfa1/v/t34.0-12/12283211_538795716295369_950391577_n.jpg?oh=d93960b23bdd2ac49fe1c616587a1f9f&oe=5653C078")
        );
        
        cakeRepository.save(new Cake("Cheese Cake",900.00,"No Description",
        (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
        "https://scontent-sin1-1.xx.fbcdn.net/hphotos-xfp1/v/t34.0-12/12278167_538796939628580_559691794_n.jpg?oh=90a45dc7bbc438f5955c788fdcf413c6&oe=5653F61C")
        );
        
        cakeRepository.save(new Cake("Tiramisu Cake",800.00,"No Description",
        (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
        "https://scontent-sin1-1.xx.fbcdn.net/hphotos-xfp1/v/t34.0-12/12272877_538795889628685_1002211352_n.jpg?oh=8731b109b422610beb517c52e7bcc422&oe=5653F89F")
        );
        
        cakeRepository.save(new Cake("Banoffee",800.00,"No Description",
        (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
        "https://scontent-sin1-1.xx.fbcdn.net/hphotos-xap1/v/t34.0-12/12286015_538795996295341_1932978214_n.jpg?oh=7740b9585c206c8f7748e2b6a0221a0a&oe=5653BFF5")
        );

    }
}

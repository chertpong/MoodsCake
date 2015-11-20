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
        cakeRepository.save(new Cake("Cheese cake",100.00,"Cheese cake with high quality cheese",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(1.0,2.0),
                "http://www.bbcgoodfood.com/sites/default/files/chocolate-avocado-cake.jpg")
        );
        cakeRepository.save(new Cake("Strawberry cake",200.00,"Strawberry cake with high quality strawberry",
                (Set)(new HashSet(Arrays.asList(Topping.Strawberries))),Arrays.asList(1.0,2.0,3.0),
                "http://www.coldstonecreamery.com/assets/img/products/signaturecakes/signature-cakes-strawberrypassion.jpg")
        );
        cakeRepository.save(new Cake("Black forest cake",150.00,"Big black forest cake",
                (Set)(new HashSet(Arrays.asList(Topping.Macaroons,Topping.Strawberries))),Arrays.asList(2.0,3.0),
                "https://upload.wikimedia.org/wikipedia/commons/6/66/Black_Forest_gateau.jpg")
        );

    }
}

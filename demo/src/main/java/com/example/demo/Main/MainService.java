package com.example.demo.Main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.Brands.Brands;
import com.example.demo.Shoes.Shoes;
import com.example.demo.Shoes.ShoesRepository;

@Service
public class MainService {
    
    @Autowired
    private ShoesRepository shoesRepository;

    // show product
    public void showProductService(Model model){
        System.out.print("Hello 1");
        List<Shoes> shoes = (List<Shoes>) shoesRepository.findAll();
        System.out.print("Hello 2");
        System.out.println("Hello " + shoesRepository.findById(20).get());
        model.addAttribute("shoes", shoes);
    }

    // search
    public void searchDataService(Model model, Shoes shoes){
        Brands brands = new Brands();
        Shoes searchShoes = shoesRepository.findById(shoes.getId()).get();
        searchShoes.setBrand(brands);
        model.addAttribute("searchShoes",searchShoes);
    }

    // get keyword
    public void getKeywordService(Model model){
        Shoes shoes = new Shoes();
        model.addAttribute("shoe", shoes);
    }
}

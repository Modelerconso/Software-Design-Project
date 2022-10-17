package com.example.demo.Shoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.Brands.Brands;
import com.example.demo.Brands.BrandsRepository;

@Service
public class ShoesService {

    @Autowired 
    private ShoesRepository shoesRepository ;
    @Autowired 
    private BrandsRepository brandsRepository ;

    // Add
    public void addShoesServices(Shoes shoes){
        shoesRepository.save(shoes);
    }
    public void createShoesServices(Model model){
        List<Brands> brands = (List<Brands>) brandsRepository.findAll();
        model.addAttribute("brands", brands);
        Shoes shoes = new Shoes();
        shoes.setBrand(new Brands());
        model.addAttribute("shoes", shoes);
    }
    
    // Delete
    public void deleteShoesService(Integer id) {
        Shoes shoe = shoesRepository.findById((int) id).get();
        shoesRepository.deleteById(shoe.getId());
    }

    // Update
    public String updateShoesService(Shoes shoes){
        shoesRepository.save(shoes);
        return "redirect:/" ;
    }
    public void editShoesService(Integer id, Model model) {
        Shoes shoe = shoesRepository.findById(id).get();
        shoe.setBrand(new Brands());
        model.addAttribute("shoe", shoe);

        List<Brands> brands = (List<Brands>) brandsRepository.findAll();
        model.addAttribute("brands", brands);
    }
}

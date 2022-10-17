package com.example.demo.Brands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BrandsService {
    
    @Autowired
    private BrandsRepository brandsRepository ;
    
    // add brand
    public void addBrandsService(Brands brand){
        brandsRepository.save(brand);
    }
    public void createBrandsService(Model model){
        Brands brands = new Brands();
        model.addAttribute("brand", brands);
    }
    
    // edit brand
    public void editBrandsService(Model model){
        List<Brands> brand = (List<Brands>) brandsRepository.findAll();
        model.addAttribute("brands", brand);
    }

    // delete brand
    public void deleteBrandsService(Integer id){
        Brands brand = brandsRepository.findById((int) id).get();
        brandsRepository.deleteById(brand.getId());
    }

}

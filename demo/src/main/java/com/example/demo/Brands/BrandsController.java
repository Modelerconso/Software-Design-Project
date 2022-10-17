package com.example.demo.Brands;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandsController {

    private BrandsService service ;
    
    public BrandsController(BrandsService service){
        this.service = service;
    }

    // add
    @PostMapping("/add-brand")
    public String addBrand(@Validated Brands brand){
        service.addBrandsService(brand);
        return "redirect:/edit-brands";
    }
    @GetMapping("/create-brand")
    public String createBrand(Model model){
        service.createBrandsService(model);
        return "CreateBrands";
    }
    
    // delete
    @GetMapping("/delete-brand")
    public String deleteBrand(@RequestParam("deleteBrand") Integer id) {
        service.deleteBrandsService(id);
        return "redirect:/edit-brands";
    }

    // Edit
    @GetMapping("/edit-brands")
    public String editBrands(Model model) {
        service.editBrandsService(model);
        return "EditBrands";
    } 
    
}
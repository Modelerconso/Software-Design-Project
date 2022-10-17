package com.example.demo.Shoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoesController {
    
    private ShoesService service ;

    public ShoesController(ShoesService service){
        this.service = service ;
    }

    // Add
    @PostMapping("/add-shoes")
    public String addShoes(@Validated Shoes shoes){
        service.addShoesServices(shoes);
        return "redirect:/";
    }
    @GetMapping("/create-shoes")
    public String createShoes(Model model){
        service.createShoesServices(model);
        return "CreateShoes";
    }

    // Delete
    @GetMapping("/delete-shoes")
    public String deleteShoes(@RequestParam("deleteShoes") Integer id) {
        service.deleteShoesService(id);
        return "redirect:/";
    }

    // Update
    @PostMapping("/update-shoes/{id}")
    public String updateShoes(@Validated Shoes shoes){
        service.updateShoesService(shoes);
        return "redirect:/" ;
    }
    @GetMapping("/edit-shoes")
    public String editShoes(@RequestParam("EditProduct") Integer id, Model model) {
        service.editShoesService(id, model);
        return "EditShoes"; 
    }
}
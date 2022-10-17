package com.example.demo.Main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Shoes.Shoes;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private MainService service ;

    public MainController(MainService service){
        this.service = service;
    }

    // Index
    @RequestMapping("/")
    public String showProduct(Model model){
        service.showProductService(model);
        return "Index";
    }
    @GetMapping("/Index")
    public String indexPage() {
        return "redirect:/"; 
    }
    
    // Search
    @PostMapping("/search")
    public String searchData(@Validated Shoes shoes, Model model) {
        try{
            service.searchDataService(model, shoes);
            return "SuccessSearch";
        }catch(Exception e){
            return "FailSearch";
        }
    }
    @GetMapping("/search")
    public String getKeyword(Model model) {
        service.getKeywordService(model);
        return "Search"; 
    }
}
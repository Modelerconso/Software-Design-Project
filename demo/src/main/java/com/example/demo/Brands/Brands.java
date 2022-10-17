package com.example.demo.Brands;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.Shoes.Shoes;

@Entity
@Table(name = "Brands")
public class Brands {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id ;
    
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Shoes> shoes ;

    private String name ;

    public Set<Shoes> getShoes() {
        return shoes;
    }

    public void setShoes(Set<Shoes> shoes) {
        this.shoes = shoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Clothe;
import com.example.demo.model.enums.Category;

public interface  ClotheRepository extends JpaRepository<Clothe,Long> {
    
  List <Clothe>findByCategory(Category category);

    

}














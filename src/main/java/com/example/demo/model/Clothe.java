package com.example.demo.model;

import jakarta.persistence.Lob;

import lombok.Data;


import com.example.demo.model.enums.Category;

import jakarta.persistence.*;


@Data

@Entity

public class Clothe {


  @Id

  @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id ;

    private String name ;

  

    @Enumerated(EnumType.STRING)

    private Category category;
  
      private String shortDescription ;
     

      @Lob

      private  String description ;
    
    private Integer sellingPrice;

    private Integer discountPrice;

    @Lob

    private byte[] clothesImage ;

   

}

package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.enums.Category;
import com.example.demo.repository.ClotheRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PageController {


  private final ClotheRepository clotheRepository ;

   public  PageController(ClotheRepository clotheRepository){
    this.clotheRepository=clotheRepository;
}

    @GetMapping("/")
    public String index(Model model){
 
 model.addAttribute("clothes",clotheRepository.findByCategory(Category.CLOTHE));
   model.addAttribute("bags",clotheRepository.findByCategory(Category.BAGS));    
         return "index";
    }
    


    @GetMapping("/about")
    public String about (){ 
        return "about";

    }

    @GetMapping("/contact")
    public String contact(){
return "contact";
    }

    
@GetMapping ("/admin/cloth/clothescategory")
public String clothescategory(Model model){

 model.addAttribute("clothes", clotheRepository.findByCategory(Category.CLOTHE));

    return "clothescategory";
}
     
@GetMapping("/admin/cloth/bagscategory")
public String bagscategory(Model model){



       model.addAttribute("bags",clotheRepository.findByCategory(Category.BAGS));
    return "bagscategory";

}


     @GetMapping("/bags")
    public String bags(){
        return "bags";
    }

    @GetMapping("/sale")
    public String sale (Model model){
 model.addAttribute("clothes",clotheRepository.findByCategory(Category.CLOTHE));
   model.addAttribute("bags",clotheRepository.findByCategory(Category.BAGS));
        return "sale";
    }
    @GetMapping("/login")
    public String login(){
        return "login" ;
    }



    
}


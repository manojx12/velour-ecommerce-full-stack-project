package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PageController {
    @GetMapping("/")
    public String index(Model model){
 
    
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

    @GetMapping("clothing")
    public String clothing(){
        return "clothing" ;

    }

     @GetMapping("/bags")
    public String bags(){
        return "bags";
    }

    @GetMapping("/sale")
    public String sale (){
        return "sale";
    }
    @GetMapping("/login")
    public String login(){
        return "login" ;
    }

}

 package com.example.demo.controller;

import com.example.demo.model.enums.Category;

import java.io.IOException;

import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Clothe;
import com.example.demo.repository.ClotheRepository;



 @Controller

 @RequestMapping("/admin/cloth")

 public class ClotheController {

  private final ClotheRepository clotheRepository ;

   public  ClotheController(ClotheRepository clotheRepository){
    this.clotheRepository=clotheRepository;
}

    @GetMapping
    public String addClothes(Model model ){

        model.addAttribute("clothes",clotheRepository.findAll());
        return "admin/cloth/viewClothes";
        
    }


    @GetMapping("/add")
    public String addClothesForm(Model model) {
      model.addAttribute("clothe",new Clothe());
      model.addAttribute("categories",Category.values());
        return "admin/cloth/addClothes";
    }



@PostMapping("/add")

public String addClothe(@ModelAttribute Clothe clothe,
    @RequestParam("imageFile") MultipartFile imageFile )
    throws IOException {


        if (!imageFile.isEmpty()){
            clothe.setClothesImage(imageFile.getBytes());
        }
        clotheRepository.save(clothe);
        return "redirect:/admin/cloth";

    }

  @GetMapping("/update/{id}")

  public String updateClothesFrom(@PathVariable Long id,Model model){
        Clothe clothe = clotheRepository.findById(id).orElse(new Clothe());
        
        model.addAttribute("clothe", clothe);
        model.addAttribute("categories", Category.values());

        return "admin/cloth/updateClothes";
  }
@PostMapping("/update")

public String Updateclothes(@ModelAttribute Clothe clothe,
                             @RequestParam("imageFile") MultipartFile imageFile)
    throws IOException   {
    
    if (!imageFile.isEmpty()) {
        clothe.setClothesImage(imageFile.getBytes());
    }
    clotheRepository.save(clothe);
    
    return "redirect:/admin/cloth";
}


@GetMapping("delete/{id}")

public  String deleteClthoes(@PathVariable Long id){
    clotheRepository.deleteById(id);


    return "redirect:/admin/cloth";
}

@GetMapping("/image/{id}")

@ResponseBody
public byte[] getImage(@PathVariable Long id ){


  Clothe clothe = clotheRepository.findById(id).orElseThrow();
    
  return clothe.getClothesImage();
}

    



}

package com.example.UP.Controllers;

import com.example.UP.Models.Color;
import com.example.UP.Repositories.ColorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'PURCHASING')")
public class ColorController {
    @Autowired
    ColorRepo colorRepo;

    @GetMapping("/color")
    public String main(Model model){
        Iterable<Color> listColor = colorRepo.findAll();
        model.addAttribute("listColor", listColor);
        return "Color/index";
    }

    @GetMapping("/color/add")
    public String colorAddView(Color color, Model model){
        return "Color/add";
    }

    @PostMapping("/color/add")
    public String colorAdd(@RequestParam String NameColor,
                           Model model){
        Color color = new Color(NameColor);
        colorRepo.save(color);
        return ("redirect:/color");
    }

    @GetMapping("/color/del/{id}")
    public String colorDelete(@PathVariable Long id) {
        colorRepo.deleteById(id);
        return("redirect:/color");
    }
}

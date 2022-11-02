package com.example.UP.Controllers;

import com.example.UP.Models.Material;
import com.example.UP.Repositories.MaterialRepo;
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
public class MaterialController {
    @Autowired
    MaterialRepo materialRepo;

    @GetMapping("/material")
    public String main(Model model){
        Iterable<Material> listMaterial = materialRepo.findAll();
        model.addAttribute("listMaterial", listMaterial);
        return "/Material/index";
    }

    @GetMapping("/material/add")
    public String materialAddView(Material material, Model model){
        return "Material/add";
    }

    @PostMapping("/material/add")
    public String materialAdd(@RequestParam String NameMaterial,
                              Model model){
        Material material = new Material(NameMaterial);
        materialRepo.save(material);
        return ("redirect:/material");
    }

    @GetMapping("/material/del/{id}")
    public String materialDelete(@PathVariable Long id) {
        materialRepo.deleteById(id);
        return("redirect:/material");
    }
}

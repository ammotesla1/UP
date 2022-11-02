package com.example.UP.Controllers;

import com.example.UP.Models.ProductType;
import com.example.UP.Repositories.ProductTypeRepo;
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
public class ProductTypeController {
    @Autowired
    ProductTypeRepo productTypeRepo;

    @GetMapping("/productType")
    public String main(Model model){
        Iterable<ProductType> listProductType = productTypeRepo.findAll();
        model.addAttribute("listProductType", listProductType);
        return "ProductType/index";
    }

    @GetMapping("/productType/add")
    public String productTypeAddView(ProductType productType, Model model){
        return "ProductType/add";
    }

    @PostMapping("/productType/add")
    public String productTypeAdd(@RequestParam String NameType,
                                 Model model){
        ProductType productType = new ProductType(NameType);
        productTypeRepo.save(productType);
        return ("redirect:/productType");
    }

    @GetMapping("/productType/del/{id}")
    public String productTypeDelete(@PathVariable Long id) {
        productTypeRepo.deleteById(id);
        return("redirect:/productType");
    }
}

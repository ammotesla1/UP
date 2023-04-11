package com.example.UP.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class BucketController {
    @PostMapping("/bucket/add")
    public String productAdd(@RequestParam MultipartFile imageProduct,
                             @RequestParam String nameProduct,
                             @RequestParam Integer amount,
                             @RequestParam Double weight,
                             @RequestParam Double price,
                             @RequestParam String dateOfProduction,
//                             @RequestParam String supplier,
//                             @RequestParam String warehouse,
                             Model model){
//        Supplier supplierRepo1 = supplierRepo.findById(Long.valueOf(supplier.split(" ")[0])).orElseThrow();
//        Warehouse warehouseRepo1 = warehouseRepo.findByAddress(warehouse);
        
//        productService.saveProductToDB(imageProduct,nameProduct,amount,weight,price, dateOfProduction);

//        Product product = new Product(nameProduct, amount, weight, price, dateOfProduction,image , supplierRepo1, warehouseRepo1);
//        productRepo.save(product);
        return ("redirect:/product");
    }

}

package com.example.UP.Controllers;

import com.example.UP.Models.Order;
import com.example.UP.Models.Plan;
import com.example.UP.Models.Product;
import com.example.UP.Repositories.PlanRepo;
import com.example.UP.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'PURCHASING', 'WAREHOUSE')")
public class PlanProductController {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/plan_product")
    public String planProductView(Model model){
        Iterable<Plan> listPlan = planRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();

        model.addAttribute("listPlan", listPlan);
        model.addAttribute("listProduct", listProduct);
        return "/Plan/index";
    }

    @GetMapping("/plan_product/add")
    public String planProductAddView(Model model){
        Iterable<Plan> listPlan = planRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();

        model.addAttribute("listPlan", listPlan);
        model.addAttribute("listProduct", listProduct);
        return "/PlanProduct/add";
    }

    @PostMapping("/plan_product/add")
    public String planProductAdd(@RequestParam String numberPlan, @RequestParam String productName, Model model){
        Plan plan = planRepo.findById(Long.valueOf(numberPlan.split(" ")[0])).orElseThrow();
        Product product = productRepo.findById(Long.valueOf(productName.split(" ")[0])).orElseThrow();

        List<Product> productList = plan.getProduct();
        productList.add(product);

        plan.setProduct(productList);
        planRepo.save(plan);
        return ("redirect:/plan_product");
    }
}

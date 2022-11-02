package com.example.UP.Controllers;

import com.example.UP.Models.*;
import com.example.UP.Repositories.EmployeeRepo;
import com.example.UP.Repositories.PlanRepo;
import com.example.UP.Repositories.ProductRepo;
import com.example.UP.Repositories.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'PURCHASING', 'WAREHOUSE')")
public class PlanController {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    SupplierRepo supplierRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/plan")
    public String main(Model model){
        Iterable<Plan> listPlan = planRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Employee> listEmployee = employeeRepo.findAll();

        model.addAttribute("listPlan", listPlan);
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listEmployee", listEmployee);
        return "/Plan/index";
    }

    @GetMapping("/plan/add")
    public String planAddView(Plan plan, Model model){
        Iterable<Product> listProduct = productRepo.findAll();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Employee> listEmployee = employeeRepo.findAll();

        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listEmployee", listEmployee);
        return "/Plan/add";
    }

    @PostMapping("/plan/add")
    public String planAdd(@RequestParam String Date_Of_Registration,
                          @RequestParam String supplier,
                          @RequestParam String employee,
                          Model model){
        Supplier supplier1 = supplierRepo.findById(Long.valueOf(supplier.split(" ")[0])).orElseThrow();
        Employee employee1 = employeeRepo.findById(Long.valueOf(employee.split(" ")[0])).orElseThrow();

        Plan plan = new Plan(Date_Of_Registration, supplier1, employee1);
        planRepo.save(plan);
        return ("redirect:/plan");
    }

    @GetMapping("/plan/filter-direct")
    public String planFilterDirect(@RequestParam String searchName,
                                   Model model){
        List<Plan> plan = planRepo.findByDateOfRegistration(searchName);
        model.addAttribute("plan", plan);
        return "/Plan/filter";
    }

    @GetMapping("/plan/filter-contains")
    public String planFilterContains(@RequestParam String searchName,
                                     Model model){
        List<Plan> plan = planRepo.findByDateOfRegistrationContaining(searchName);
        model.addAttribute("plan", plan);
        return "/Plan/filter";
    }

    @GetMapping("plan/del/{id}")
    public String planDelete(@PathVariable Long id) {
        planRepo.deleteById(id);
        return("redirect:/plan");
    }
}

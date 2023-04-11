package com.example.UP.Controllers;

import com.example.UP.Models.*;
import com.example.UP.Repositories.*;
import com.example.UP.Services.OrderService;
import com.example.UP.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
//@PreAuthorize("hasAnyAuthority('ADMIN', 'WAREHOUSE', 'CASHIER')")
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    SupplierRepo supplierRepo;
    @Autowired
    WarehouseRepo warehouseRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    //@PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'WAREHOUSE', 'CASHIER', 'PURCHASING', 'DELIVERY')")
    @GetMapping("/product")
    public String main(Model model){
        Iterable<Product> listProduct = productRepo.findAll();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Warehouse> listWarehouse = warehouseRepo.findAll();

        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listWarehouse", listWarehouse);
        return "/Product/index";
    }


    @PostMapping("/product/add")
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
        productService.saveProductToDB(imageProduct,nameProduct,amount,weight,price, dateOfProduction);
//        Product product = new Product(nameProduct, amount, weight, price, dateOfProduction,image , supplierRepo1, warehouseRepo1);
//        productRepo.save(product);
        return ("redirect:/product");
    }

    //@PreAuthorize("hasAnyAuthority('ADMIN', 'VIEWER', 'WAREHOUSE', 'CASHIER', 'PURCHASING', 'DELIVERY')")
    @GetMapping("/product/filter-contains")
    public String productFilterContains(@RequestParam String searchName,
                                         Model model){
        List<Product> product = productRepo.findByNameProductContaining(searchName);
        model.addAttribute("product", product);
        return "/Product/filter";
    }

    @GetMapping("/product/details/{id}")
    public String productDetails(Model model, @PathVariable Long id) {
        Product product = productRepo.findById(id).orElseThrow();
        Iterable<Supplier> listSupplier = supplierRepo.findAll();
        Iterable<Warehouse> listWarehouse = warehouseRepo.findAll();

        model.addAttribute("product", product);
        model.addAttribute("listSupplier", listSupplier);
        model.addAttribute("listWarehouse", listWarehouse);
        return ("/Product/details");
    }

    @GetMapping("product/del/{id}")
    public String productDelete(@PathVariable Long id) {
        productRepo.deleteById(id);
        return("redirect:/product");
    }

    @PostMapping("/product/edit/{id}")
    public String productEdit(Product product,
                              Model model) {

        productRepo.save(product);
        return("redirect:/product");
    }
    @GetMapping("/product/stats")
    public String stats(Model model){
        List<String> productName = orderService.getAllOrders().stream().map(x->x.getProduct().getNameProduct()).collect(Collectors.toList());
        List<Double> productCost = orderService.getAllOrders().stream().map(x->x.getProduct().getPrice()).collect(Collectors.toList());
        List<Integer> productAmount = orderService.getAllOrders().stream().map(x->x.getProduct().getAmount()).collect(Collectors.toList());

        model.addAttribute("productName", productName);
        model.addAttribute("productCost", productCost);
        model.addAttribute("productAmount", productAmount);
        return "/Product/stats";
    }
}

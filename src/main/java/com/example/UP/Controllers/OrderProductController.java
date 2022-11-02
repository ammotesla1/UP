package com.example.UP.Controllers;

import com.example.UP.Models.Order;
import com.example.UP.Models.Product;
import com.example.UP.Repositories.OrderRepo;
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
@PreAuthorize("hasAnyAuthority('ADMIN', 'CASHIER')")
public class OrderProductController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/order_product")
    public String orderProductView(Model model){
        Iterable<Order> listOrder = orderRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();

        model.addAttribute("listOrder", listOrder);
        model.addAttribute("listProduct", listProduct);
        return "/Order/index";
    }

    @GetMapping("/order_product/add")
    public String orderProductAddView(Model model){
        Iterable<Order> listOrder = orderRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();

        model.addAttribute("listOrder", listOrder);
        model.addAttribute("listProduct", listProduct);
        return "/OrderProduct/add";
    }

    @PostMapping("/order_product/add")
    public String orderProductAdd(@RequestParam String numberOrder, @RequestParam String productName, Model model){
        Order order = orderRepo.findById(Long.valueOf(numberOrder.split(" ")[0])).orElseThrow();
        Product product = productRepo.findById(Long.valueOf(productName.split(" ")[0])).orElseThrow();

        List<Product> productList = order.getProduct();
        productList.add(product);

        order.setProduct(productList);
        orderRepo.save(order);
        return ("redirect:/order_product");
    }
}

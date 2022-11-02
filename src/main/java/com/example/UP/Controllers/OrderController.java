package com.example.UP.Controllers;

import com.example.UP.Models.*;
import com.example.UP.Repositories.ClientRepo;
import com.example.UP.Repositories.OrderRepo;
import com.example.UP.Repositories.ProductRepo;
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
@PreAuthorize("hasAnyAuthority('ADMIN', 'CASHIER')")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/order")
    public String main(Model model){
        Iterable<Order> listOrder = orderRepo.findAll();
        Iterable<Client> listClient = clientRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();

        model.addAttribute("listOrder", listOrder);
        model.addAttribute("listClient", listClient);
        model.addAttribute("listProduct", listProduct);
        return "/Order/index";
    }

    @GetMapping("/order/add")
    public String orderAddView(Order order, Model model){
        Iterable<Client> listClient = clientRepo.findAll();
        Iterable<Product> listProduct = productRepo.findAll();

        model.addAttribute("listClient", listClient);
        model.addAttribute("listProduct", listProduct);
        return "/Order/add";
    }

    @PostMapping("/order/add")
    public String orderAdd(@RequestParam String dateOfRelease,
                           @RequestParam String client,
                           Model model){
        Client client1 = clientRepo.findById(Long.valueOf(client.split(" ")[0])).orElseThrow();

        Order order = new Order(dateOfRelease, client1);
        orderRepo.save(order);
        return ("redirect:/order");
    }

    @GetMapping("/order/filter-direct")
    public String orderFilterDirect(@RequestParam String searchName,
                                    Model model){
        List<Order> order = orderRepo.findByDateOfRelease(searchName);
        model.addAttribute("order", order);
        return "/Order/filter";
    }

    @GetMapping("/order/filter-contains")
    public String orderFilterContains(@RequestParam String searchName,
                                      Model model){
        List<Order> order = orderRepo.findByDateOfReleaseContaining(searchName);
        model.addAttribute("order", order);
        return "/Order/filter";
    }

    @GetMapping("/order/del/{id}")
    public String orderDelete(@PathVariable Long id) {
        orderRepo.deleteById(id);
        return("redirect:/order");
    }
}

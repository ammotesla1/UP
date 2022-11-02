package com.example.UP.Controllers;

import com.example.UP.Models.Supplier;
import com.example.UP.Models.Warehouse;
import com.example.UP.Repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class WarehouseController {
    @Autowired
    WarehouseRepo warehouseRepo;

    @GetMapping("/warehouse")
    public String main(Model model){
        Iterable<Warehouse> listWarehouse = warehouseRepo.findAll();
        model.addAttribute("listWarehouse", listWarehouse);
        return "Warehouse/index";
    }

    @GetMapping("/warehouse/add")
    public String warehouseAddView(Warehouse warehouse, Model model){
        return "Warehouse/add";
    }

    @PostMapping("/warehouse/add")
    public String warehouseAdd(@RequestParam String Address,
                               @RequestParam Integer Capacity,
                               Model model){
        Warehouse warehouse = new Warehouse(Address, Capacity);
        warehouseRepo.save(warehouse);
        return ("redirect:/warehouse");
    }

    @GetMapping("/warehouse/filter-contains")
    public String warehouseFilterContains(@RequestParam String searchName,
                                          Model model){
        List<Warehouse> warehouse = warehouseRepo.findByAddressContaining(searchName);
        model.addAttribute("warehouse", warehouse);
        return "/Warehouse/filter";
    }

    @GetMapping("/warehouse/del/{id}")
    public String warehouseDelete(@PathVariable Long id) {
        warehouseRepo.deleteById(id);
        return("redirect:/warehouse");
    }
}

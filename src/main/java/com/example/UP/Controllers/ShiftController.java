package com.example.UP.Controllers;

import com.example.UP.Models.Shift;
import com.example.UP.Repositories.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class ShiftController {
    @Autowired
    ShiftRepo shiftRepo;

    @GetMapping("/shift")
    public String main(Model model){
        Iterable<Shift> listShift = shiftRepo.findAll();
        model.addAttribute("listShift", listShift);
        return "/Shift/index";
    }

    @GetMapping("/shift/add")
    public String shiftAddView(Shift shift, Model model){
        return "Shift/add";
    }

    @PostMapping("/shift/add")
    public String shiftAdd(@RequestParam String NameShift, @RequestParam String Date_Start_Shift, @RequestParam String Date_End_Shift, Model model){
        Shift shift = new Shift(NameShift, Date_Start_Shift, Date_End_Shift);
        shiftRepo.save(shift);
        return ("redirect:/shift");
    }

    @GetMapping("/shift/del/{id}")
    public String shiftDelete(@PathVariable Long id) {
        shiftRepo.deleteById(id);
        return("redirect:/shift");
    }
}

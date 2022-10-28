package com.example.P50519.Controllers;

import com.example.P50519.Models.Tovar;
import com.example.P50519.Models.TovarColor;
import com.example.P50519.Models.TovarReg;
import com.example.P50519.Models.Factory;
import com.example.P50519.Repositories.TovarRepository;
import com.example.P50519.Repositories.TovarColorRepository;
import com.example.P50519.Repositories.TovarRegRepository;
import com.example.P50519.Repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class TovarController {

    @Autowired
    TovarRepository tovarRepository;
    @Autowired
    FactoryRepository factoryRepository;
    @Autowired
    TovarColorRepository tovarColorRepository;
    @Autowired
    TovarRegRepository tovarRegRepository;

    @GetMapping("/tovar")
    public String Tovar(Model model) {

        Iterable<Tovar> listTovar = tovarRepository.findAll();
        Iterable<Factory> listFactory = factoryRepository.findAll();
        Iterable<TovarColor> listTovarColor = tovarColorRepository.findAll();
        Iterable<TovarReg> listTovarReg = tovarRegRepository.findAll();



        model.addAttribute(("list_tovars"), listTovar);
        model.addAttribute(("list_factorys"), listFactory);
        model.addAttribute(("list_tovarColors"), listTovarColor);
        model.addAttribute(("list_tovarReg"), listTovarReg);
        return ("tovar/index");
    }

    @GetMapping("/tovar/tovarFactoryADD")
    public String tovarFactoryADD(Model model) {

        Iterable<Tovar> listTovar = tovarRepository.findAll();
        Iterable<Factory> listFactory = factoryRepository.findAll();

        model.addAttribute(("tovars"), listTovar);
        model.addAttribute(("factorys"), listFactory);
        return ("tovar/tovarFactoryADD");
    }

    @PostMapping("/tovar/tovarFactoryADD")
    public String tovarFactoryADD(@RequestParam String tovar_name,
                                  @RequestParam String factory_name) {

        Tovar tovar = tovarRepository.findById(Long.valueOf(tovar_name.split("\\|")[0])).orElseThrow();
        Factory factory = factoryRepository.findById(Long.valueOf(factory_name.split("\\|")[0])).orElseThrow();

        List<Factory> factorysList = tovar.getFactorys();
        factorysList.add(factory);

        tovar.setFactorys(factorysList);

        tovarRepository.save(tovar);
        return ("redirect:/tovar");
    }

    @GetMapping("/tovar/add")
    public String TovarAdd(Model model) {

        Iterable<TovarColor> tovarColors = tovarColorRepository.findAll();
        Iterable<TovarReg> tovarRegs = tovarRegRepository.findAll();
        ArrayList<TovarReg> tovarRegArrayList = new ArrayList<>();

        for(TovarReg cr: tovarRegs) {
            if(cr.getTovar() == null) {
                tovarRegArrayList.add(cr);
            }
        }

        model.addAttribute("colors", tovarColors);
        model.addAttribute("regs", tovarRegArrayList);

        return ("tovar/tovarADD");
    }

    @PostMapping("/tovar/add")
    public String TovarAdd(@RequestParam String tovarName,
                           @RequestParam Integer tovarCost,
                           @RequestParam String tovarColor,
                           @RequestParam String tovarReg) {

        TovarColor tovarColor1 = tovarColorRepository.findByMainColor(tovarColor.split("\\|")[0]);
        TovarReg tovarReg1 = tovarRegRepository.findBySign(tovarReg);

        Tovar tovar = new Tovar(tovarName, tovarCost, tovarReg1, tovarColor1);
        tovarRepository.save(tovar);
        return ("redirect:/tovar");
    }

    @GetMapping("/tovar/tovarColorADD")
    public String colorADD() {

        return ("tovar/tovarColorADD");
    }

    @PostMapping("/tovar/tovarColorADD")
    public String colorADD(@RequestParam String main,
                           @RequestParam String sub) {

        TovarColor tovarColor = new TovarColor(main, sub);
        tovarColorRepository.save(tovarColor);
        return ("redirect:/tovar");
    }

    @GetMapping("/tovar/tovarRegADD")
    public String regADD() {

        return ("tovar/tovarRegADD");
    }

    @PostMapping("/tovar/tovarRegADD")
    public String regADD(@RequestParam String sign,
                         @RequestParam String INN) {

        TovarReg tovarReg = new TovarReg(sign, INN);
        tovarRegRepository.save(tovarReg);
        return ("redirect:/tovar");
    }

    @GetMapping("/tovar/factoryADD")
    public String factoryADD() {

        return ("tovar/factoryADD");
    }

    @PostMapping("/tovar/factoryADD")
    public String factoryADD(@RequestParam String address,
                             @RequestParam String name) {

        Factory factory = new Factory(address, name);
        factoryRepository.save(factory);
        return ("redirect:/tovar");
    }
}

package com.example.P50519.Controllers;

import com.example.P50519.Models.Tovar;
import com.example.P50519.Repositories.TovarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/tovar")
@PreAuthorize("hasAnyAuthority('USER')")
public class TovarController {

    @Autowired
    TovarRepository tovarRepository;

    @GetMapping("")
    public String Tovar(Model model) {

        Iterable<Tovar> listTovar = tovarRepository.findAll();
        model.addAttribute(("list_tovars"), listTovar);
        return ("tovar/index");
    }

    @GetMapping("/add")
    public String TovarAddView(Tovar tovar) {
        return ("tovar/tovarADD");
    }

    @PostMapping("/add")
    public String TovarAdd(@Valid Tovar tovar,
                           BindingResult result) { //BindingResult - Передаёт ошибки на страницу

        if(result.hasErrors())
            return ("tovar/tovarADD");

        tovarRepository.save(tovar);
        return ("redirect:/tovar");
    }

    @GetMapping("/filterACCU")
    public String TovarFilterACCU(Model model,
                                @RequestParam(name = "search") String tovarName) {

        List<Tovar> tovar = tovarRepository.findByTovarName(tovarName); //Добавляем все записи содержащие заданное значение в список
        model.addAttribute("searchRes", tovar); //Передаём в модель список
        return ("tovar/tovarFilter"); //Отображаем страницу поиска
    }

    @GetMapping("/filter")
    public String TovarFilter(Model model,
                              @RequestParam(name = "search") String tovarName) {

        List<Tovar> tovar = tovarRepository.findByTovarNameContains(tovarName); //Добавляем все записи содержащие заданное значение в список
        model.addAttribute("searchRes", tovar); //Передаём в модель список
        return ("tovar/tovarFilter"); //Отображаем страницу поиска
    }

    @GetMapping("/details/{id}")
    public String TovarDetails(Model model,
                               @PathVariable long id) {

        Tovar tovar = tovarRepository.findById(id).orElseThrow(); //Ищем запись по ID
        model.addAttribute("tovar", tovar); //Передаём в модель запись
        return ("/tovar/tovarDetails"); //Отображаем страницу деталей
    }

    @GetMapping("/tovarDEL/{id}")
    public String TovarDelete(@PathVariable long id) {

        tovarRepository.deleteById(id); //Удаление записи по ID
        return("redirect:/tovar"); //Перенаправление на страницу машин
    }

    @GetMapping("/edit/{id}")
    public String TovarEdit(Model model,
                            @PathVariable long id,
                            Tovar tovar_) {

        Tovar tovar = tovarRepository.findById(id).orElseThrow(); //Поиск записи по ID
        model.addAttribute("tovar", tovar); //Передаём в модель запись
        return("/tovar/tovarEDT"); //Отображение страницы редактирования
    }

    @PostMapping("/edit/{id}")
    public String TovarEdit(@Valid Tovar tovar,
                            BindingResult result) {

        if(result.hasErrors())
            return ("tovar/tovarEDT");

        tovarRepository.save(tovar); //Сохранение изменений

        return("redirect:/tovar/details/" + tovar.getId()); //Перенаправление на страницу деталей
    }
}

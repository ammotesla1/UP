package com.example.UP.Controllers;

import com.example.UP.Models.Employee;
import com.example.UP.Models.Post;
import com.example.UP.Models.Shift;
import com.example.UP.Repositories.EmployeeRepo;
import com.example.UP.Repositories.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ShiftRepo shiftRepo;

    @GetMapping("/employee")
    public String main(Model model){
        Iterable<Employee> listEmployee = employeeRepo.findAll();
        Iterable<Shift> listShift = shiftRepo.findAll();

        model.addAttribute("listEmployee", listEmployee);
        model.addAttribute("listShift", listShift);
        return "/Employee/index";
    }

    @GetMapping("/employee/filter-direct")
    public String employeeFilterDirect(@RequestParam String searchName,
                                       Model model){
        List<Employee> employee = employeeRepo.findBySurname(searchName);
        model.addAttribute("employee", employee);
        return "/Employee/filter";
    }

    @GetMapping("/employee/filter-contains")
    public String employeeFilterContains(@RequestParam String searchName,
                                         Model model){
        List<Employee> employee = employeeRepo.findBySurnameContaining(searchName);
        model.addAttribute("employee", employee);
        return "/Employee/filter";
    }

    @GetMapping("/employee/details/{id}")
    public String employeeDetails(Model model, @PathVariable Long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow();
        model.addAttribute("employee", employee);
        return ("/Employee/details");
    }

    @GetMapping("/employee/del/{id}")
    public String employeeDelete(@PathVariable Long id) {
        employeeRepo.deleteById(id);
        return("redirect:/employee");
    }

    @GetMapping("/employee/edit/{id}")
    public String employeeEdit(Model model, @PathVariable Long id, Employee employee_) {
        Employee employee = employeeRepo.findById(id).orElseThrow();
        Iterable<Shift> listShift = shiftRepo.findAll();

        model.addAttribute("employee", employee);
        model.addAttribute("listShift", listShift);
        model.addAttribute("listPost", Post.values());
        return("/Employee/edit");
    }

    @PostMapping("/employee/edit/{id}")
    public String employeeEdit(@PathVariable Long id,
                               @RequestParam String email,
                               @RequestParam String surname,
                               @RequestParam String name,
                               @RequestParam String middleName,
                               @RequestParam String phone,
                               @RequestParam String[] posts) {
        Employee employee = employeeRepo.findById(id).orElseThrow();
        employee.setEmail(email);
        employee.setSurname(surname);
        employee.setName(name);
        employee.setMiddleName(middleName);
        employee.setPhone(phone);
        employee.getPost().clear();
        //employee.setShift(shift);

        for(String post: posts){
            employee.getPost().add(Post.valueOf(post));
        }

        employeeRepo.save(employee);
        return("redirect:/employee/details/" + employee.getId());
    }
}

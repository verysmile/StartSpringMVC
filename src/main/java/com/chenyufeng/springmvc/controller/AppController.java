package com.chenyufeng.springmvc.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.chenyufeng.springmvc.model.Employee;
import com.chenyufeng.springmvc.service.EmployeeService;
import com.wordnik.swagger.annotations.ApiParam;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emp")
public class AppController {

    @Autowired
    EmployeeService service;

    @Autowired
    MessageSource messageSource;

    @ResponseBody
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public List<Employee> listEmployees() {
        List<Employee> employees = service.findAllEmployees();
        return employees;
    }

    @ResponseBody
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveEmployee(
            @ApiParam(value = "用户名", required = true) @RequestParam String name,
            @ApiParam(value = "日期", required = true) @RequestParam String joiningDate,
            @ApiParam(value = "薪水", required = true) @RequestParam BigDecimal salary,
            @ApiParam(value = "ssn", required = true) @RequestParam String ssn
    ) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setJoiningDate(joiningDate);
        employee.setSalary(salary);
        employee.setSsn(ssn);

        service.saveEmployee(employee);

        return "success";
    }

    @RequestMapping(value = {"/edit-{ssn}-employee"}, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = service.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }

    @RequestMapping(value = {"/edit-{ssn}-employee"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
                                 ModelMap model, @PathVariable String ssn) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())) {
            FieldError ssnError = new FieldError("employee", "ssn", messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }

        service.updateEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getName() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-{ssn}-employee"}, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        service.deleteEmployeeBySsn(ssn);
        return "redirect:/list";
    }

}
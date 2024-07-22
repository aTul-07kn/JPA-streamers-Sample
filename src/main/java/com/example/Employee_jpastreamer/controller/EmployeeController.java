package com.example.Employee_jpastreamer.controller;

import com.example.Employee_jpastreamer.model.Employee;
import com.example.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public List<Employee> addEmployee(@RequestBody List<Employee> empList){
        return employeeService.addEmployee(empList);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupEmployeeByCity(){
        return employeeService.groupEmployeeByCity();
    }

    @GetMapping("/findByPaymentTier/{paymentTier}")
    public List<Employee> findEmployeesByPaymentTier(@PathVariable int paymentTier){
        return employeeService.findEmployeesByPaymentTier(paymentTier);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/findByAgeRanges")
    public List<Employee> findByAgeRanges(@RequestParam("min age") int minAge, @RequestParam("max age") int maxAge){
        return employeeService.findByAgeRanges(minAge, maxAge);
    }

    @GetMapping("/countByGender/{gender}")
    public String countByGender(@PathVariable String gender){
        return employeeService.countByGender(gender);
    }

    @GetMapping("/countByGenderByYear/{year}")
    public Map<String, Long> countByGenderByYear(@PathVariable int year){
        return employeeService.countByGenderByYear(year);
    }

    @GetMapping("/getEmployeesByYear/{year}")
    public List<Employee> getEmployeesByYear(@PathVariable int year){
        return employeeService.getEmployeesByYear(year);
    }

    @GetMapping("/groupEmployeesByEducation")
    public Map<String, List<Employee>> groupEmployeesByEducation(){
        return employeeService.groupEmployeesByEducation();
    }

    @GetMapping("/groupEmployeesByYear")
    public Map<Integer, List<Employee>> groupEmployeesByYear(){
        return employeeService.groupEmployeesByYear();
    }

    @GetMapping("/multipleFilters")
    public List<Employee> getEmployeesByFilters(@RequestParam("Joining year") int year, @RequestParam("Gender") String gender, @RequestParam("Experience") int experience, @RequestParam("education") String education){
        return employeeService.getEmployeesByFilters(year,gender,experience, education);
    }
}

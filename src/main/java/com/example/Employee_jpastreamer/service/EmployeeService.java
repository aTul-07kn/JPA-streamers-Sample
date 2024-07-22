package com.example.Employee_jpastreamer.service;

import com.example.Employee_jpastreamer.model.Employee;
import com.example.Employee_jpastreamer.repository.Employeerepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private Employeerepo employeeRepo;

    @Autowired
    private JPAStreamer jpaStreamer;

    public Map<String, List<Employee>> groupEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> addEmployee(List<Employee> empList) {
        return employeeRepo.saveAll(empList);
    }

    public List<Employee> findEmployeesByPaymentTier(int paymentTier) {
        return employeeRepo.findByPaymentTier(paymentTier);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> findByAgeRanges(int minAge, int maxAge) {
        return employeeRepo.findByAgeBetween(minAge, maxAge);
    }

    public String countByGender(String gender){
        long totalCount=jpaStreamer.stream(Employee.class)
                .filter(emp->emp.getGender().equalsIgnoreCase(gender))
                .count();
        return "Total number of "+gender+"s are "+totalCount;
    }

    public Map<String, Long> countByGenderByYear(int year) {
        return jpaStreamer.stream(Employee.class)
                .filter(emp->emp.getJoiningYear()==year)
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    public List<Employee> getEmployeesByYear(int year) {
        return jpaStreamer.stream(Employee.class)
                .filter(emp->emp.getJoiningYear()==year)
                .toList();
    }

    public Map<String, List<Employee>> groupEmployeesByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public Map<Integer, List<Employee>> groupEmployeesByYear() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getJoiningYear));
    }

    public List<Employee> getEmployeesByFilters(int year, String gender, int experience, String education) {
        return jpaStreamer.stream(Employee.class)
                .filter(emp->emp.getJoiningYear()==year && emp.getGender().equalsIgnoreCase(gender) && emp.getExperienceInCurrentDomain()==experience && emp.getEducation().equalsIgnoreCase(education))
                .toList();
    }
}
package com.example.Employee_jpastreamer.repository;

import com.example.Employee_jpastreamer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Employeerepo extends JpaRepository<Employee, String> {
    List<Employee> findByPaymentTier(int paymentTier);

    List<Employee> findByAgeBetween(int minAge, int maxAge);
}

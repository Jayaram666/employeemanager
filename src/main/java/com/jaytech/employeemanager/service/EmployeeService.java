package com.jaytech.employeemanager.service;

import com.jaytech.employeemanager.exception.UserNotFoundException;
import com.jaytech.employeemanager.model.Employee;
import com.jaytech.employeemanager.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployee(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found")
        );
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteEmployeeById(employeeId);

    }
}

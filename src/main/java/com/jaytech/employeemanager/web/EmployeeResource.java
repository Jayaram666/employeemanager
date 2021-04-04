package com.jaytech.employeemanager.web;

import com.jaytech.employeemanager.model.Employee;
import com.jaytech.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> listOfEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.findEmployee(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        ResponseEntity<Employee> employeeResponseEntity = new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        return employeeResponseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        ResponseEntity<Employee> employeeResponseEntity = new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        return employeeResponseEntity;
    }

    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
         employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

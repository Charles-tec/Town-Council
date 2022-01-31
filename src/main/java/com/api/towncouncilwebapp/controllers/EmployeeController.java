package com.api.towncouncilwebapp.controllers;

import com.api.towncouncilwebapp.dtos.EmployeeDto;
import com.api.towncouncilwebapp.dtos.EmployeeResponseDto;
import com.api.towncouncilwebapp.dtos.SingleEmployeeResponseDto;
import com.api.towncouncilwebapp.models.Employee;
import com.api.towncouncilwebapp.repositories.EmployeeRepository;
import com.api.towncouncilwebapp.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponseDto> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }
    @Operation(summary = "get employee by id", description = "", tags = "employee")
    @GetMapping("/employees/{id}")
    public ResponseEntity<SingleEmployeeResponseDto>getOneEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.getOneEmployee(id));
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable("id")Integer id,@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id){
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

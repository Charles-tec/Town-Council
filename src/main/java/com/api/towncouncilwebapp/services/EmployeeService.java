package com.api.towncouncilwebapp.services;

import com.api.towncouncilwebapp.dtos.EmployeeDto;
import com.api.towncouncilwebapp.dtos.EmployeeResponseDto;
import com.api.towncouncilwebapp.dtos.SingleEmployeeResponseDto;
import com.api.towncouncilwebapp.models.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

   //create employee
   EmployeeResponseDto createEmployee(EmployeeDto employeeDto);

   //update employee
  // EmployeeResponseDto updateEmployee(EmployeeDto employeeDto);

   EmployeeResponseDto updateEmployee(Integer id, EmployeeDto employeeDto);

   EmployeeResponseDto getEmployees();

   SingleEmployeeResponseDto getOneEmployee(Integer id);

   EmployeeResponseDto deleteEmployee(Integer id);
}

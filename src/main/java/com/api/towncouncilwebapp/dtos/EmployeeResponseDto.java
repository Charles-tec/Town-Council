package com.api.towncouncilwebapp.dtos;

import com.api.towncouncilwebapp.models.Employee;
import lombok.Data;

import java.util.List;
import java.util.Optional;


@Data
public class EmployeeResponseDto {
    Integer status;
    String message;
    List<Employee> employee;
    Optional<Employee> employees;
}

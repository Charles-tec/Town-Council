package com.api.towncouncilwebapp.dtos;

import com.api.towncouncilwebapp.models.Employee;
import lombok.Data;

import javax.swing.text.html.Option;
import java.util.Optional;

@Data
public class SingleEmployeeResponseDto {
    Integer status;
    String message;
    Optional<Employee> employee;
}

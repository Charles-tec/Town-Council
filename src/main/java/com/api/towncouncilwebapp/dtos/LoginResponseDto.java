package com.api.towncouncilwebapp.dtos;

import com.api.towncouncilwebapp.models.Employee;
import lombok.Data;


@Data
public class LoginResponseDto {
    Integer status;
    String message;
    Employee employee;
}

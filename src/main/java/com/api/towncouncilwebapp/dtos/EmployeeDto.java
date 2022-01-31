package com.api.towncouncilwebapp.dtos;

import com.api.towncouncilwebapp.models.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;


@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;
}

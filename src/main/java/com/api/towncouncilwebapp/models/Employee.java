package com.api.towncouncilwebapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@RequiredArgsConstructor
@Data
@Entity
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userName"}),
})

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;


    @Column(name = "username")
    private String username;

    @JsonIgnore
    private String email;


    private String password;

    @JsonIgnore
    private String phone;

  //  @JsonIgnore
    private String address;

    @JsonIgnore
    @Column(name = "status")
    private boolean status;

   @JsonIgnore
    @Column(name = "islogged")
    private boolean isLogged;


}

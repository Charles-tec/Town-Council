package com.api.towncouncilwebapp.repositories;


import com.api.towncouncilwebapp.models.Employee;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   //find user by username
   Employee findByUsername(String username);

 // Employee deleteEmployeeByUsername(String username);

  void deleteById(Integer id);

  List<Employee> findAll();

    Optional<Employee> findById(Integer id);


}

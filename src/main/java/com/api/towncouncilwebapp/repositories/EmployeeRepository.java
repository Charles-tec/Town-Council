package com.api.towncouncilwebapp.repositories;


import com.api.towncouncilwebapp.models.Employee;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   //find user by username
   Employee findByUsername(String username);

   Employee findEmployeeById(long Id);
}

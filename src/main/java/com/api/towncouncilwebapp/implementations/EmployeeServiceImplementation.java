package com.api.towncouncilwebapp.implementations;


import com.api.towncouncilwebapp.dtos.EmployeeDto;
import com.api.towncouncilwebapp.dtos.EmployeeResponseDto;
import com.api.towncouncilwebapp.dtos.SingleEmployeeResponseDto;
import com.api.towncouncilwebapp.models.Employee;
import com.api.towncouncilwebapp.repositories.EmployeeRepository;
import com.api.towncouncilwebapp.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public EmployeeResponseDto getEmployees(){
        List<Employee> employees=employeeRepository.findAll();
        EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
        employeeResponseDto.setStatus(200);
        employeeResponseDto.setMessage("success");
        employeeResponseDto.setEmployee(employees);
        return employeeResponseDto;

    }
    @Override
    public SingleEmployeeResponseDto getOneEmployee(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        SingleEmployeeResponseDto singleEmployeeResponseDto=new SingleEmployeeResponseDto();
        singleEmployeeResponseDto.setStatus(200);
        singleEmployeeResponseDto.setMessage("success");
        singleEmployeeResponseDto.setEmployee(employee);
        return singleEmployeeResponseDto;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeDto employeeDto) {
        Employee employees=new Employee();
        employees.setFirstName(employeeDto.getFirstName());
        employees.setLastName(employeeDto.getLastName());
        employees.setUsername(employeeDto.getUsername());
        employees.setEmail(employeeDto.getEmail());
        employees.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employees.setPhone(employeeDto.getPhone());
        employees.setAddress((employeeDto.getAddress()));
        employees.setLogged(false);
        employees.setStatus(true);
        employeeRepository.save(employees);
     EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
        employeeResponseDto.setStatus(200);
        employeeResponseDto.setMessage("employee created");
        return  employeeResponseDto;
    }



    @Override
    public EmployeeResponseDto updateEmployee(Integer id, EmployeeDto employeeDto){

        /*
        1.
         */
        Employee employee = employeeRepository.findByUsername(employeeDto.getUsername());
        if(employee==null){
            throw new EntityNotFoundException("username not found");
        }


        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employee.setPhone(employeeDto.getPhone());
        employee.setAddress((employeeDto.getAddress()));
        employee.setLogged(false);
        employee.setStatus(true);
        employeeRepository.save(employee);
        EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
        employeeResponseDto.setStatus(200);
        employeeResponseDto.setMessage("employee updated");
        employeeResponseDto.setEmployee(Collections.singletonList(employee));
        return  employeeResponseDto;
    }




    public EmployeeResponseDto deleteEmployee(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        EmployeeResponseDto employeeResponseDto=new EmployeeResponseDto();
        employeeResponseDto.setStatus(200);
        employeeResponseDto.setMessage("employee deleted succesfully");

        return  employeeResponseDto;
    }
}






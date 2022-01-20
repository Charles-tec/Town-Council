package com.api.towncouncilwebapp.implementations;


import com.api.towncouncilwebapp.dtos.LoginResponseDto;
import com.api.towncouncilwebapp.exceptions.InvalidLoginException;
import com.api.towncouncilwebapp.exceptions.UnexpectedErrorException;
import com.api.towncouncilwebapp.repositories.EmployeeRepository;
import com.api.towncouncilwebapp.services.AuthorisationService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorisationServiceImplementation implements AuthorisationService {

    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public LoginResponseDto login(String username, String password) {

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
         throw new UnexpectedErrorException("Username or password is empty", "username or password is empty");
        }

        var employee = employeeRepository.findByUsername(username);
        if(employee == null) {

            throw new InvalidLoginException("Invalid username or password", "Invalid username or password");
        }
        boolean isPasswordMatches = passwordEncoder.matches(password, employee.getPassword());
        if(!isPasswordMatches) {
           throw new InvalidLoginException("Invalid username or password", "Invalid username or password");
        }

        if(employee.isLogged()){
            throw new InvalidLoginException("User is already logged in", "User is already logged in");
        }

        if(!employee.isStatus()){
            throw new InvalidLoginException("User is not active", "User is not active");
        }


        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setStatus(200);
        loginResponseDto.setMessage("Login Successful");
        loginResponseDto.setEmployee(employee);
        return loginResponseDto;
    }


}


package com.api.towncouncilwebapp.services;

import com.api.towncouncilwebapp.dtos.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthorisationService {

    LoginResponseDto login (String username, String password);



}

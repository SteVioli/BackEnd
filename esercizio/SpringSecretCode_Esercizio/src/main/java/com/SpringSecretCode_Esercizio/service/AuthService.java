package com.SpringSecretCode_Esercizio.service;

import com.SpringSecretCode_Esercizio.payload.LoginDto;
import com.SpringSecretCode_Esercizio.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}

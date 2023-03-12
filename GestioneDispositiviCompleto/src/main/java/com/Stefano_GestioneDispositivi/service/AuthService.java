package com.Stefano_GestioneDispositivi.service;

import com.Stefano_GestioneDispositivi.payload.LoginDto;
import com.Stefano_GestioneDispositivi.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}

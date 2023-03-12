package com.Stefano_GestioneDispositivi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Stefano_GestioneDispositivi.models.ERole;
import com.Stefano_GestioneDispositivi.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}

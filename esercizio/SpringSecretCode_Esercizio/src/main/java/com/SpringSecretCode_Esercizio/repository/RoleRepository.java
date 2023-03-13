package com.SpringSecretCode_Esercizio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecretCode_Esercizio.entity.ERole;
import com.SpringSecretCode_Esercizio.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}

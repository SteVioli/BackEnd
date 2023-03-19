package com.appIncendio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appIncendio.entities.DispositivoProcess;

public interface ProcessRepository extends JpaRepository<DispositivoProcess, Long> {

}

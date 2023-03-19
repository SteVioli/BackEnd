package com.appIncendio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "processi")
public class DispositivoProcess implements ProcessFactory{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer smokeLevel;
	
	@Override
	public boolean update(Integer newSmokeLevel) {
		this.smokeLevel = newSmokeLevel;
		if(newSmokeLevel >= 5) {
			return true;
		}else {
			return false;
		}
	}
	
}

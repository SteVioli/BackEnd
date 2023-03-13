package com.SpringSecretCode_Esercizio.entity;

import org.hibernate.validator.constraints.Length;

import com.SpringSecretCode_Esercizio.configuration.AppartamentoSecurity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appartamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Length(min = 5,max = 20)
	@Convert(converter = AppartamentoSecurity.class)
	private String password;
}

package com.SpringSecretCode_Esercizio.configuration;

import jakarta.persistence.AttributeConverter;

public class AppartamentoSecurity implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		
		return attribute + "gatto";
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		
		return dbData.replaceAll("gatto", "");
	}

}

package com.appIncendio.entities;


import com.appIncendio.utils.TipoDispositivo;

// Pattern Factory per creazione di vari tipi dispositivo,
//in questo caso SONDA, ma volendo seguendo la stessa logica posso creare diversi tipi
public class DispositivoFactory {

	public static Dispositivo createDispositivo(TipoDispositivo type) {
		
		if (type == null) {
			return null;
		}
		if (type.equals(TipoDispositivo.SONDA)) {
			return new Sonda(TipoDispositivo.SONDA, 0, 0, 0);
		}
		return null;
	}
}

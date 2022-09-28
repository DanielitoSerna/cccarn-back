package co.com.ccarn.services;

import co.com.ccarn.dtos.ListaChequeoDto;
import co.com.ccarn.dtos.ResponseDto;

public interface IEncabezadoListaChequeoService {
	
	public ResponseDto guardarEncabezadoListaChequeo(ListaChequeoDto listaChequeoDto);

}

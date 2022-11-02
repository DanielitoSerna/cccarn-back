package co.com.ccarn.services;

import co.com.ccarn.dtos.EncabezadoRegistroDto;
import co.com.ccarn.dtos.ResponseDto;

public interface IRegistroService {
	
	public ResponseDto guardar(EncabezadoRegistroDto encabezadoRegistroDto);

}

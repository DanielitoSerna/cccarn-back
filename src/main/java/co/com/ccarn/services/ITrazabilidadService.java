package co.com.ccarn.services;

import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.dtos.TrazabilidadDto;

public interface ITrazabilidadService {
	
	public ResponseDto guardarTrazabilidad(TrazabilidadDto trazabilidadDto);

}

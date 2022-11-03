package co.com.ccarn.services;

import co.com.ccarn.dtos.CaracterizacionDto;
import co.com.ccarn.dtos.ResponseDto;

public interface ICaracterizacionService {
	
	public ResponseDto guardar(CaracterizacionDto caracterizacionDto);

}

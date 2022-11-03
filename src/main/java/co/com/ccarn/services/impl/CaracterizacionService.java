package co.com.ccarn.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.CaracterizacionDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.model.Caracterizacion;
import co.com.ccarn.repositories.CaracterizacionRepository;
import co.com.ccarn.services.ICaracterizacionService;

@Service
public class CaracterizacionService implements ICaracterizacionService {
	
	@Autowired
	private CaracterizacionRepository caracterizacionRepository;
	
	@Autowired
	private CerrarConexionService cerrarConexionService;

	@Override
	public ResponseDto guardar(CaracterizacionDto caracterizacionDto) {
		ResponseDto responseDto = new ResponseDto();
		Caracterizacion caracterizacion = convertirDtoToEntidad(caracterizacionDto);
		try {
			caracterizacionRepository.save(caracterizacion);
			responseDto.setCodigo("Informativo");
			responseDto.setMensaje("Se guardó correctamente la caracterización");
			cerrarConexionService.cerrarConexion();
		} catch (Exception e) {
			responseDto.setCodigo("Error");
			responseDto.setMensaje("Error al guardar la caracterización");
			e.printStackTrace();
			cerrarConexionService.cerrarConexion();
			return responseDto;
		}
		return responseDto;
	}
	
	private Caracterizacion convertirDtoToEntidad(CaracterizacionDto caracterizacionDto) {
		ModelMapper modelMapper = new ModelMapper();
		Caracterizacion caracterizacion = modelMapper.map(caracterizacionDto, Caracterizacion.class);
		return caracterizacion;
	}

}

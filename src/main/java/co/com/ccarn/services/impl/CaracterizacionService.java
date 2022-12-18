package co.com.ccarn.services.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.CaracterizacionDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.excel.ExcelGeneratorCaracterizacion;
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
		if (caracterizacionDto.getId() != null) {
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
		} else  {
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
		}
		return responseDto;
	}
	
	public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=caracterizacion.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Caracterizacion> lista = caracterizacionRepository.findAll();
        ExcelGeneratorCaracterizacion generator = new ExcelGeneratorCaracterizacion(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}

	private Caracterizacion convertirDtoToEntidad(CaracterizacionDto caracterizacionDto) {
		ModelMapper modelMapper = new ModelMapper();
		Caracterizacion caracterizacion = modelMapper.map(caracterizacionDto, Caracterizacion.class);
		return caracterizacion;
	}

}

package co.com.ccarn.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.dtos.TrazabilidadDto;
import co.com.ccarn.model.Trazabilidad;
import co.com.ccarn.repositories.TrazabilidadRepository;
import co.com.ccarn.services.ITrazabilidadService;

@Service
public class TrazabilidadService implements ITrazabilidadService {
	
	@Autowired
	private CerrarConexionService cerrarConexionService;
	
	@Autowired
	private TrazabilidadRepository trazabilidadRepository;

	@Override
	public ResponseDto guardarTrazabilidad(TrazabilidadDto trazabilidadDto) {
		ResponseDto responseDto = new ResponseDto();
		if (trazabilidadDto.getId()!= null) {
			Trazabilidad trazabilidad = mapeoToEntidad(trazabilidadDto);
			Trazabilidad trazabilidadGuardado = null;
			try {
				trazabilidadGuardado = trazabilidadRepository.save(trazabilidad);
				System.out.println(trazabilidadGuardado.getId() + " < < < < ID");
				if (trazabilidadGuardado != null) {
					responseDto.setCodigo("Informativo");
					responseDto.setMensaje("Se actualizó correctamente el registro, " + trazabilidadGuardado.getId());
				}
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar la trazabilidad");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
		} else {
			Trazabilidad trazabilidad = mapeoToEntidad(trazabilidadDto);
			Trazabilidad trazabilidadGuardado = null;
			try {
				trazabilidadGuardado = trazabilidadRepository.save(trazabilidad);
				System.out.println(trazabilidadGuardado.getId() + " < < < < ID");
				if (trazabilidadGuardado != null) {
					responseDto.setCodigo("Informativo");
					responseDto.setMensaje("Se guardó correctamente el registro, " + trazabilidadGuardado.getId());
				}
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar la trazabilidad");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
		}
		return responseDto;
	}
	
	private Trazabilidad mapeoToEntidad(TrazabilidadDto trazabilidadDto) {
		ModelMapper modelMapper = new ModelMapper();
		Trazabilidad trazabilidad = modelMapper.map(trazabilidadDto, Trazabilidad.class);
		return trazabilidad;
	}

}

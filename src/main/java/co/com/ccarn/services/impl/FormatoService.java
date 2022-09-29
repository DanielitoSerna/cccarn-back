package co.com.ccarn.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.FormatoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.model.Formato;
import co.com.ccarn.repositories.FormatoRepository;
import co.com.ccarn.services.IFormatoService;

@Service
public class FormatoService implements IFormatoService {
	
	@Autowired
	private FormatoRepository formatoRepository;

	@Override
	public ResponseDto guardarFormato(FormatoDto formatoDto) {
		ResponseDto responseDto = new ResponseDto();
		Formato formato = convertirDtoToEntidadFormato(formatoDto);
		Formato formatoGuardado = null;
		try {
			formatoGuardado = formatoRepository.save(formato);
		} catch (Exception e) {
			responseDto.setCodigo("Error");
			responseDto.setMensaje("Error al guardar encabezado");
			e.printStackTrace();
			return responseDto;
		}
		if (formatoGuardado != null) {
			responseDto.setCodigo("Informativo");
			responseDto.setMensaje("Se guardó correctamente el formato, " + formatoGuardado.getId());
		} else {
			responseDto.setCodigo("Error");
			responseDto.setMensaje("Error al guardar el formato");
		}
		return responseDto;
	}

	private Formato convertirDtoToEntidadFormato(FormatoDto formatoDto) {
		ModelMapper modelMapper = new ModelMapper();
		Formato formato = modelMapper.map(formatoDto, Formato.class);
		return formato;
	}

}

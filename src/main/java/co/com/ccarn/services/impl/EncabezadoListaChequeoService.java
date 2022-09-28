package co.com.ccarn.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.ListaChequeoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.model.ListaChequeo;
import co.com.ccarn.repositories.EncabezadoListaChequeoRepository;
import co.com.ccarn.services.IEncabezadoListaChequeoService;

@Service
public class EncabezadoListaChequeoService implements IEncabezadoListaChequeoService {
	
	@Autowired
	private EncabezadoListaChequeoRepository encabezadoListaChequeoRepository;

	@Override
	public ResponseDto guardarEncabezadoListaChequeo(ListaChequeoDto listaChequeoDto) {
		ResponseDto responseDto = new ResponseDto();
		ListaChequeo listaChequeo = convertToEntity(listaChequeoDto);
		ListaChequeo listaChequeoGuardado = encabezadoListaChequeoRepository.save(listaChequeo);
		if(listaChequeoGuardado != null) {
			responseDto.setCodigo("Informativo");
			responseDto.setMensaje("Se guardó correctamente el encabezado, " +listaChequeoGuardado.getId());
		} else {
			responseDto.setCodigo("Error");
			responseDto.setMensaje("Error al guardar encabezado");
		}
		return responseDto;
	}
	
	private ListaChequeoDto convertToDto(ListaChequeo listaChequeo) {
		ModelMapper modelMapper = new ModelMapper();
		ListaChequeoDto listaChequeoDto = modelMapper.map(listaChequeo, ListaChequeoDto.class);
		return listaChequeoDto;
	}
	
	private ListaChequeo convertToEntity(ListaChequeoDto listaChequeoDto) {
		ModelMapper modelMapper = new ModelMapper();
		ListaChequeo listaChequeo = modelMapper.map(listaChequeoDto, ListaChequeo.class);
		return listaChequeo;
	}

}

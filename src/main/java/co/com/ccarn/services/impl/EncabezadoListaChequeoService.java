package co.com.ccarn.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.ConceptoListaChequeoDto;
import co.com.ccarn.dtos.DetalleListaChequeoDto;
import co.com.ccarn.dtos.ListaChequeoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.model.ConceptoListaChequeo;
import co.com.ccarn.model.DetalleListaChequeo;
import co.com.ccarn.model.ListaChequeo;
import co.com.ccarn.repositories.ConceptoListaChequeoRepository;
import co.com.ccarn.repositories.DetalleListaChequeoRepository;
import co.com.ccarn.repositories.EncabezadoListaChequeoRepository;
import co.com.ccarn.services.IEncabezadoListaChequeoService;

@Service
public class EncabezadoListaChequeoService implements IEncabezadoListaChequeoService {

	@Autowired
	private EncabezadoListaChequeoRepository encabezadoListaChequeoRepository;
	
	@Autowired
	private ConceptoListaChequeoRepository conceptoListaChequeoRepository;
	
	@Autowired
	private DetalleListaChequeoRepository detalleListaChequeoRepository;

	@Override
	public ResponseDto guardarEncabezadoListaChequeo(ListaChequeoDto listaChequeoDto) {
		ResponseDto responseDto = new ResponseDto();
		ListaChequeo listaChequeo = convertirDtoToEntidadEncabezado(listaChequeoDto);
		ListaChequeo listaChequeoGuardado = null;
		try {
			listaChequeoGuardado = encabezadoListaChequeoRepository.save(listaChequeo);
		} catch (Exception e) {
			responseDto.setCodigo("Error");
			responseDto.setMensaje("Error al guardar encabezado");
			e.printStackTrace();
			return responseDto;
		}
		if (listaChequeoGuardado != null) {
			ConceptoListaChequeo conceptoListaChequeo = convertirDtoToEntidadConcepto(listaChequeoDto.getConcepto());
			conceptoListaChequeo.setListaChequeoBean(listaChequeoGuardado);
			try {
				conceptoListaChequeoRepository.save(conceptoListaChequeo);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar el concepto");
				e.printStackTrace();
				return responseDto;
			}
			for (DetalleListaChequeoDto detalleDto : listaChequeoDto.getDetalle()) {
				DetalleListaChequeo detalleListaChequeo = convertirDtoToEntidadDetalle(detalleDto);
				detalleListaChequeo.setListaChequeoBean(listaChequeoGuardado);
				try {
					detalleListaChequeoRepository.save(detalleListaChequeo);
				} catch (Exception e) {
					responseDto.setCodigo("Error");
					responseDto.setMensaje("Error al guardar el concepto");
					e.printStackTrace();
					return responseDto;
				}
			}
			responseDto.setCodigo("Informativo");
			responseDto.setMensaje("Se guardó correctamente la lista de chequeo, " + listaChequeoGuardado.getId());
		} else {
			responseDto.setCodigo("Error");
			responseDto.setMensaje("Error al guardar lista de chequeo");
		}
		return responseDto;
	}

	private DetalleListaChequeo convertirDtoToEntidadDetalle(DetalleListaChequeoDto detalleDto) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleListaChequeo detalleListaChequeo = modelMapper.map(detalleDto, DetalleListaChequeo.class);
		return detalleListaChequeo;
	}

	private ConceptoListaChequeo convertirDtoToEntidadConcepto(ConceptoListaChequeoDto concepto) {
		ModelMapper modelMapper = new ModelMapper();
		ConceptoListaChequeo conceptoListaChequeo = modelMapper.map(concepto, ConceptoListaChequeo.class);
		return conceptoListaChequeo;
	}

	private ListaChequeo convertirDtoToEntidadEncabezado(ListaChequeoDto listaChequeoDto) {
		ModelMapper modelMapper = new ModelMapper();
		ListaChequeo listaChequeo = modelMapper.map(listaChequeoDto, ListaChequeo.class);
		return listaChequeo;
	}

}

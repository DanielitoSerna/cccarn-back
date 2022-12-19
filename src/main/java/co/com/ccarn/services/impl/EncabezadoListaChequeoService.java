package co.com.ccarn.services.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.ConceptoListaChequeoDto;
import co.com.ccarn.dtos.DetalleListaChequeoDto;
import co.com.ccarn.dtos.ListaChequeoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.excel.ExcelGeneratorAsi;
import co.com.ccarn.excel.ExcelGeneratorBpg;
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

	@Autowired
	private CerrarConexionService cerrarConexionService;

	@Override
	public ResponseDto guardarEncabezadoListaChequeo(ListaChequeoDto listaChequeoDto) {
		ResponseDto responseDto = new ResponseDto();
		if (listaChequeoDto.getId() != null) {
			ListaChequeo listaChequeo = convertirDtoToEntidadEncabezado(listaChequeoDto);
			ListaChequeo listaChequeoGuardado = null;
			try {
				listaChequeoGuardado = encabezadoListaChequeoRepository.save(listaChequeo);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar encabezado");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
			if (listaChequeoGuardado != null) {
				if (listaChequeoGuardado.getId().equals(listaChequeo.getId())) {
					try {
						List<ConceptoListaChequeo> listaChequeos = conceptoListaChequeoRepository
								.findByListaChequeoBean(listaChequeo);
						for (ConceptoListaChequeo conceptoListaChequeo : listaChequeos) {
							conceptoListaChequeoRepository.delete(conceptoListaChequeo);
						}
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al actualizar lista");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
					try {
						List<DetalleListaChequeo> listaChequeos = detalleListaChequeoRepository
								.findByListaChequeoBean(listaChequeo);
						for (DetalleListaChequeo detalleListaChequeo : listaChequeos) {
							detalleListaChequeoRepository.delete(detalleListaChequeo);
						}
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al actualizar lista");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				ConceptoListaChequeo conceptoListaChequeo = convertirDtoToEntidadConcepto(
						listaChequeoDto.getConcepto());
				conceptoListaChequeo.setListaChequeoBean(listaChequeoGuardado);
				try {
					conceptoListaChequeoRepository.save(conceptoListaChequeo);
				} catch (Exception e) {
					responseDto.setCodigo("Error");
					responseDto.setMensaje("Error al guardar el concepto");
					e.printStackTrace();
					cerrarConexionService.cerrarConexion();
					return responseDto;
				}
				for (DetalleListaChequeoDto detalleDto : listaChequeoDto.getDetalle()) {
					DetalleListaChequeo detalleListaChequeo = convertirDtoToEntidadDetalle(detalleDto);
					detalleListaChequeo.setListaChequeoBean(listaChequeoGuardado);
					try {
						detalleListaChequeoRepository.save(detalleListaChequeo);
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al guardar el detalle");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				responseDto.setCodigo("Informativo");
				responseDto
						.setMensaje("Se actualizó correctamente la lista de chequeo, " + listaChequeoGuardado.getId());
				cerrarConexionService.cerrarConexion();
			} else {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar lista de chequeo");
			}
		} else {
			ListaChequeo listaChequeo = convertirDtoToEntidadEncabezado(listaChequeoDto);
			ListaChequeo listaChequeoGuardado = null;
			try {
				listaChequeoGuardado = encabezadoListaChequeoRepository.save(listaChequeo);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar encabezado");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
			if (listaChequeoGuardado != null) {
				ConceptoListaChequeo conceptoListaChequeo = convertirDtoToEntidadConcepto(
						listaChequeoDto.getConcepto());
				conceptoListaChequeo.setListaChequeoBean(listaChequeoGuardado);
				try {
					conceptoListaChequeoRepository.save(conceptoListaChequeo);
				} catch (Exception e) {
					responseDto.setCodigo("Error");
					responseDto.setMensaje("Error al guardar el concepto");
					e.printStackTrace();
					cerrarConexionService.cerrarConexion();
					return responseDto;
				}
				for (DetalleListaChequeoDto detalleDto : listaChequeoDto.getDetalle()) {
					DetalleListaChequeo detalleListaChequeo = convertirDtoToEntidadDetalle(detalleDto);
					detalleListaChequeo.setListaChequeoBean(listaChequeoGuardado);
					try {
						detalleListaChequeoRepository.save(detalleListaChequeo);
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al guardar el detalle");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				responseDto.setCodigo("Informativo");
				responseDto.setMensaje("Se guardó correctamente la lista de chequeo, " + listaChequeoGuardado.getId());
				cerrarConexionService.cerrarConexion();
			} else {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar lista de chequeo");
			}
		}
		return responseDto;
	}
	
	public void exportIntoExcelFileBpg(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=lista_bpg.xlsx";
        response.setHeader(headerKey, headerValue);

        List<ListaChequeo> lista = encabezadoListaChequeoRepository.findByTipoFormato("BGP");
        ExcelGeneratorBpg generator = new ExcelGeneratorBpg(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}
	
	public void exportIntoExcelFileAsi(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=lista_asi.xlsx";
        response.setHeader(headerKey, headerValue);

        List<ListaChequeo> lista = encabezadoListaChequeoRepository.findByTipoFormato("ASI");
        ExcelGeneratorAsi generator = new ExcelGeneratorAsi(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
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

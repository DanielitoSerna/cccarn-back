package co.com.ccarn.services.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.DetalleAndrologicoDto;
import co.com.ccarn.dtos.DetalleFormatoDto;
import co.com.ccarn.dtos.FormatoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.excel.ExcelGeneratorBra;
import co.com.ccarn.excel.ExcelGeneratorIatf;
import co.com.ccarn.excel.ExcelGeneratorRecomendacion;
import co.com.ccarn.model.DetalleAndrologico;
import co.com.ccarn.model.DetalleFormato;
import co.com.ccarn.model.Formato;
import co.com.ccarn.repositories.DetalleAndrologicoRepository;
import co.com.ccarn.repositories.DetalleFormatoRepository;
import co.com.ccarn.repositories.FormatoRepository;
import co.com.ccarn.services.IFormatoService;

@Service
public class FormatoService implements IFormatoService {

	@Autowired
	private FormatoRepository formatoRepository;

	@Autowired
	private DetalleFormatoRepository detalleFormatoRepository;

	@Autowired
	private DetalleAndrologicoRepository detalleAndrologicoRepository;

	@Autowired
	private CerrarConexionService cerrarConexionService;

	@Override
	public ResponseDto guardarFormato(FormatoDto formatoDto) {
		ResponseDto responseDto = new ResponseDto();
		if (formatoDto.getId() != null) {
			Formato formato = convertirDtoToEntidadFormato(formatoDto);
			formato.setDetalleAndrologico(null);
			Formato formatoGuardado = null;
			try {
				formatoGuardado = formatoRepository.save(formato);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar encabezado");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
			if (formatoGuardado != null) {
				if (formatoGuardado.getId().equals(formato.getId())) {
					try {
						List<DetalleFormato> detalleFormatos =  detalleFormatoRepository.findByFormatoBean(formato);
						for (DetalleFormato detalleFormato : detalleFormatos) {
							detalleFormatoRepository.delete(detalleFormato);
						}
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al actualizar formato");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				if (formatoDto.getDetalleFormatos() != null && formatoDto.getDetalleFormatos().size() > 0) {
					for (DetalleFormatoDto detalleFormatoDto : formatoDto.getDetalleFormatos()) {
						DetalleFormato detalleFormato = convertirDtoToEntidadDetalleFormato(detalleFormatoDto);
						detalleFormato.setFormatoBean(formatoGuardado);
						try {
							detalleFormatoRepository.save(detalleFormato);
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al guardar el detalle del formato");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
					if (formatoDto.getDetalleAndrologico() != null) {
						DetalleAndrologico detalleAndrologico = convertirDtoToEntidadDetalleAndrologico(
								formatoDto.getDetalleAndrologico());
						detalleAndrologico.setFormatoBean(formatoGuardado);
						try {
							detalleAndrologicoRepository.save(detalleAndrologico);
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al guardar el detalle andrológico");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
				} else {
					if (formatoDto.getDetalleAndrologico() != null) {
						DetalleAndrologico detalleAndrologico = convertirDtoToEntidadDetalleAndrologico(
								formatoDto.getDetalleAndrologico());
						detalleAndrologico.setFormatoBean(formatoGuardado);
						try {
							detalleAndrologicoRepository.save(detalleAndrologico);
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al guardar el detalle andrológico");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
				}
				responseDto.setCodigo("Informativo");
				responseDto.setMensaje("Se guardó correctamente el formato, " + formatoGuardado.getId());
				cerrarConexionService.cerrarConexion();
			} else {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al actualizar el formato");
			}
		} else {
			Formato formato = convertirDtoToEntidadFormato(formatoDto);
			formato.setDetalleAndrologico(null);
			Formato formatoGuardado = null;
			try {
				formatoGuardado = formatoRepository.save(formato);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar encabezado");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
			if (formatoGuardado != null) {
				if (formatoDto.getDetalleFormatos() != null && formatoDto.getDetalleFormatos().size() > 0) {
					for (DetalleFormatoDto detalleFormatoDto : formatoDto.getDetalleFormatos()) {
						DetalleFormato detalleFormato = convertirDtoToEntidadDetalleFormato(detalleFormatoDto);
						detalleFormato.setFormatoBean(formatoGuardado);
						try {
							detalleFormatoRepository.save(detalleFormato);
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al guardar el detalle del formato");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
					if (formatoDto.getDetalleAndrologico() != null) {
						DetalleAndrologico detalleAndrologico = convertirDtoToEntidadDetalleAndrologico(
								formatoDto.getDetalleAndrologico());
						detalleAndrologico.setFormatoBean(formatoGuardado);
						try {
							detalleAndrologicoRepository.save(detalleAndrologico);
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al guardar el detalle andrológico");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
				} else {
					if (formatoDto.getDetalleAndrologico() != null) {
						DetalleAndrologico detalleAndrologico = convertirDtoToEntidadDetalleAndrologico(
								formatoDto.getDetalleAndrologico());
						detalleAndrologico.setFormatoBean(formatoGuardado);
						try {
							detalleAndrologicoRepository.save(detalleAndrologico);
						} catch (Exception e) {
							responseDto.setCodigo("Error");
							responseDto.setMensaje("Error al guardar el detalle andrológico");
							e.printStackTrace();
							cerrarConexionService.cerrarConexion();
							return responseDto;
						}
					}
				}
				responseDto.setCodigo("Informativo");
				responseDto.setMensaje("Se guardó correctamente el formato, " + formatoGuardado.getId());
				cerrarConexionService.cerrarConexion();
			} else {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar el formato");
			}
		}

		return responseDto;
	}

	private DetalleAndrologico convertirDtoToEntidadDetalleAndrologico(DetalleAndrologicoDto detalleAndrologicoDto) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleAndrologico detalleAndrologico = modelMapper.map(detalleAndrologicoDto, DetalleAndrologico.class);
		return detalleAndrologico;
	}

	private DetalleFormato convertirDtoToEntidadDetalleFormato(DetalleFormatoDto detalleFormatoDto) {
		ModelMapper modelMapper = new ModelMapper();
		DetalleFormato detalleFormato = modelMapper.map(detalleFormatoDto, DetalleFormato.class);
		return detalleFormato;
	}

	private Formato convertirDtoToEntidadFormato(FormatoDto formatoDto) {
		ModelMapper modelMapper = new ModelMapper();
		Formato formato = modelMapper.map(formatoDto, Formato.class);
		return formato;
	}
	
	public void exportIntoExcelFileRecomendacion(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=recomendaciones.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Formato> lista = formatoRepository.findByTipoFormato("RECOMENDACIONES");
        ExcelGeneratorRecomendacion generator = new ExcelGeneratorRecomendacion(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}
	
	public void exportIntoExcelFileBra(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=registro_bra.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Formato> lista = formatoRepository.findByTipoFormato("BRA");
        ExcelGeneratorBra generator = new ExcelGeneratorBra(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}
	
	public void exportIntoExcelFileIatf(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=registro_iatf.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Formato> lista = formatoRepository.findByTipoFormato("IATF");
        ExcelGeneratorIatf generator = new ExcelGeneratorIatf(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}

}

package co.com.ccarn.services.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ccarn.dtos.EncabezadoRegistroDto;
import co.com.ccarn.dtos.RegistroDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.excel.ExcelGeneratorCapacitacion;
import co.com.ccarn.excel.ExcelGeneratorPersona;
import co.com.ccarn.excel.ExcelGeneratorPotrero;
import co.com.ccarn.excel.ExcelGeneratorTratamiento;
import co.com.ccarn.model.EncabezadoRegistro;
import co.com.ccarn.model.Registro;
import co.com.ccarn.repositories.EncabezadoRegistroRepository;
import co.com.ccarn.repositories.RegistroRepository;
import co.com.ccarn.services.IRegistroService;

@Service
public class RegistroService implements IRegistroService {

	@Autowired
	private EncabezadoRegistroRepository encabezadoRegistroRepository;

	@Autowired
	private RegistroRepository registroRepository;

	@Autowired
	private CerrarConexionService cerrarConexionService;

	@Override
	public ResponseDto guardar(EncabezadoRegistroDto encabezadoRegistroDto) {
		ResponseDto responseDto = new ResponseDto();
		if (encabezadoRegistroDto.getId() != null) {
			EncabezadoRegistro encabezadoRegistro = convertirDtoToEntidadEncabezado(encabezadoRegistroDto);
			EncabezadoRegistro encabezadoRegistroGuardado = null;
			try {
				encabezadoRegistroGuardado = encabezadoRegistroRepository.save(encabezadoRegistro);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar encabezado");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
			if (encabezadoRegistroGuardado != null) {
				if (encabezadoRegistroGuardado.getId().equals(encabezadoRegistro.getId())) {
					try {
						List<Registro> registros = registroRepository.findByEncabezadoRegistroBean(encabezadoRegistro);
						for (Registro registro : registros) {
							registroRepository.delete(registro);
						}
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al actualizar registro");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				for (RegistroDto registroDto : encabezadoRegistroDto.getRegistros()) {
					Registro registro = convertirDtoToEntidadRegistro(registroDto);
					registro.setEncabezadoRegistroBean(encabezadoRegistroGuardado);
					try {
						registroRepository.save(registro);
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al guardar el detalle del registro");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				responseDto.setCodigo("Informativo");
				responseDto.setMensaje("Se guardó correctamente el registro, " + encabezadoRegistroGuardado.getId());
				cerrarConexionService.cerrarConexion();
			} else {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar el registro");
			}
		} else {
			EncabezadoRegistro encabezadoRegistro = convertirDtoToEntidadEncabezado(encabezadoRegistroDto);
			EncabezadoRegistro encabezadoRegistroGuardado = null;
			try {
				encabezadoRegistroGuardado = encabezadoRegistroRepository.save(encabezadoRegistro);
			} catch (Exception e) {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar encabezado");
				e.printStackTrace();
				cerrarConexionService.cerrarConexion();
				return responseDto;
			}
			if (encabezadoRegistroGuardado != null) {
				for (RegistroDto registroDto : encabezadoRegistroDto.getRegistros()) {
					Registro registro = convertirDtoToEntidadRegistro(registroDto);
					registro.setEncabezadoRegistroBean(encabezadoRegistroGuardado);
					try {
						registroRepository.save(registro);
					} catch (Exception e) {
						responseDto.setCodigo("Error");
						responseDto.setMensaje("Error al guardar el detalle del registro");
						e.printStackTrace();
						cerrarConexionService.cerrarConexion();
						return responseDto;
					}
				}
				responseDto.setCodigo("Informativo");
				responseDto.setMensaje("Se guardó correctamente el registro, " + encabezadoRegistroGuardado.getId());
				cerrarConexionService.cerrarConexion();
			} else {
				responseDto.setCodigo("Error");
				responseDto.setMensaje("Error al guardar el registro");
			}
		}
		return responseDto;
	}
	
	public void exportIntoExcelFileCapacitacion(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=capacitaciones.xlsx";
        response.setHeader(headerKey, headerValue);

        List<EncabezadoRegistro> lista = encabezadoRegistroRepository.findByTipoFormato("CAPACITACION");
        ExcelGeneratorCapacitacion generator = new ExcelGeneratorCapacitacion(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}
	
	public void exportIntoExcelFileTratamiento(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=tratamientos_veterinarios.xlsx";
        response.setHeader(headerKey, headerValue);

        List<EncabezadoRegistro> lista = encabezadoRegistroRepository.findByTipoFormato("VETERINARIO");
        ExcelGeneratorTratamiento generator = new ExcelGeneratorTratamiento(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}
	
	public void exportIntoExcelFilePotrero(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=manejo_potreros.xlsx";
        response.setHeader(headerKey, headerValue);

        List<EncabezadoRegistro> lista = encabezadoRegistroRepository.findByTipoFormato("POTRERO");
        ExcelGeneratorPotrero generator = new ExcelGeneratorPotrero(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}
	
	public void exportIntoExcelFilePersonas(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=control_personas_vehiculos.xlsx";
        response.setHeader(headerKey, headerValue);

        List<EncabezadoRegistro> lista = encabezadoRegistroRepository.findByTipoFormato("VEHICULO");
        ExcelGeneratorPersona generator = new ExcelGeneratorPersona(lista);
        generator.generateExcelFile(response);
        cerrarConexionService.cerrarConexion();
	}

	private EncabezadoRegistro convertirDtoToEntidadEncabezado(EncabezadoRegistroDto encabezadoRegistroDto) {
		ModelMapper modelMapper = new ModelMapper();
		EncabezadoRegistro encabezadoRegistro = modelMapper.map(encabezadoRegistroDto, EncabezadoRegistro.class);
		return encabezadoRegistro;
	}

	private Registro convertirDtoToEntidadRegistro(RegistroDto registroDto) {
		ModelMapper modelMapper = new ModelMapper();
		Registro registro = modelMapper.map(registroDto, Registro.class);
		return registro;
	}

}

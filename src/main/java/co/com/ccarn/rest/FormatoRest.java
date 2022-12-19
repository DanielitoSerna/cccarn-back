package co.com.ccarn.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ccarn.dtos.FormatoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.services.impl.FormatoService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class FormatoRest {
	
	@Autowired
	private FormatoService formatoService;
	
	@PostMapping(path = "/guardarFormato", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardarFormato(@RequestBody FormatoDto formatoDto) {
		ResponseDto responseDto = formatoService.guardarFormato(formatoDto);
		if ("Error".equals(responseDto.getCodigo())) {
			return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		}
	}
	
	@GetMapping("/recomendaciones-excel")
	public void exportIntoExcelFileRecomendacion(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileRecomendacion(response);
	}
	
	@GetMapping("/bra-excel")
	public void exportIntoExcelFileBra(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileBra(response);
	}
	
	@GetMapping("/iatf-excel")
	public void exportIntoExcelFileIatf(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileIatf(response);
	}
	
	@GetMapping("/aspiracion-excel")
	public void exportIntoExcelFileAspiracion(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileAspiracion(response);
	}
	
	@GetMapping("/donadoras-excel")
	public void exportIntoExcelFileDonadora(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileDonadora(response);
	}
	
	@GetMapping("/toros-excel")
	public void exportIntoExcelFileToros(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileToros(response);
	}
	
	@GetMapping("/hembras-excel")
	public void exportIntoExcelFileHembra(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileHembras(response);
	}
	
	@GetMapping("/andrologica-excel")
	public void exportIntoExcelFileAndrologica(HttpServletResponse response) throws IOException {
		formatoService.exportIntoExcelFileAndrologica(response);
	}

}

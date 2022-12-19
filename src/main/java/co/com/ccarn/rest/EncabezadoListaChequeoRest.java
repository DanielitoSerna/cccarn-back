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

import co.com.ccarn.dtos.ListaChequeoDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.services.impl.EncabezadoListaChequeoService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class EncabezadoListaChequeoRest {

	@Autowired
	private EncabezadoListaChequeoService encabezadoService;

	@PostMapping(path = "/guardarEncabezado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardarListaChequeo(@RequestBody ListaChequeoDto listaChequeoDto) {
		ResponseDto responseDto = encabezadoService.guardarEncabezadoListaChequeo(listaChequeoDto);
		if ("Error".equals(responseDto.getCodigo())) {
			return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		}
	}
	
	@GetMapping("/bpg-excel")
	public void exportIntoExcelFileBpg(HttpServletResponse response) throws IOException {
		encabezadoService.exportIntoExcelFileBpg(response);
	}
	
	@GetMapping("/asi-excel")
	public void exportIntoExcelFileAsi(HttpServletResponse response) throws IOException {
		encabezadoService.exportIntoExcelFileAsi(response);
	}

}

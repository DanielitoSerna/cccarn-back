package co.com.ccarn.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ccarn.dtos.GenericoDto;
import co.com.ccarn.services.impl.GenericoService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class GenericRest {
	
	@Autowired
	private GenericoService genericoService;
	
	@PostMapping(path = "/listarDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<?>> listarDatos(@RequestBody GenericoDto dto) {
		return new ResponseEntity<>(genericoService.listarDatos(dto), HttpStatus.OK);
	}

	@PostMapping(path = "/contarDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> contarDatos(@RequestBody GenericoDto dto) {
		return new ResponseEntity<>(genericoService.contarDatos(dto), HttpStatus.OK);
	}
}

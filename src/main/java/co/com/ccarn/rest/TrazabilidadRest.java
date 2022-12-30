package co.com.ccarn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.dtos.TrazabilidadDto;
import co.com.ccarn.services.impl.TrazabilidadService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class TrazabilidadRest {
	
	@Autowired
	private TrazabilidadService trazabilidadService;
	
	@PostMapping(path = "/trazabilidad", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardar(TrazabilidadDto trazabilidadDto) {
		ResponseDto responseDto = trazabilidadService.guardarTrazabilidad(trazabilidadDto);
		if ("Error".equals(responseDto.getCodigo())) {
			return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		}
	}

}

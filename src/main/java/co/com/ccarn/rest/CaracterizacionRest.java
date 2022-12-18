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

import co.com.ccarn.dtos.CaracterizacionDto;
import co.com.ccarn.dtos.ResponseDto;
import co.com.ccarn.services.impl.CaracterizacionService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class CaracterizacionRest {
	
	@Autowired
	private CaracterizacionService caracterizacionService;
	
	@PostMapping(path = "/guardarCaracterizacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardar(@RequestBody CaracterizacionDto caracterizacionDto) {
		ResponseDto responseDto = caracterizacionService.guardar(caracterizacionDto);
		if ("Error".equals(responseDto.getCodigo())) {
			return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(responseDto, HttpStatus.OK);
		}
	}
	
	@GetMapping("/caracterizacion-excel")
	public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		caracterizacionService.exportIntoExcelFile(response);
	}

}

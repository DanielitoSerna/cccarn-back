package co.com.ccarn.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrazabilidadDto {
	
	private Integer id;
	
	private String codigoInterno;
	
	private String departamento;
	
	private String din;
	
	private String dinMadre;
	
	private String dinPadre;
	
	private Date fechaNacimiento;
	
	private String identificacionGanadero;
	
	private String municipio;
	
	private String nombreGanadero;
	
	private String numeroTrabajo;
	
	private String raza;
	
	private String sexo;
	
	private String vereda;

}

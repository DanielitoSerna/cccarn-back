package co.com.ccarn.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EncabezadoRegistroDto {
	
	private Integer id;
	
	private String chapeta;
	
	private String departamento;
	
	private String empresaGanadera;
	
	private Date fechaNacimiento;
	
	private String madre;
	
	private String medicamento;
	
	private String municipio;
	
	private String nombreComercial;
	
	private String origenProveedor;
	
	private String padre;
	
	private String potrero;
	
	private String propietario;
	
	private String raza;
	
	private String registroIca;
	
	private String tipoAlimento;
	
	private String vaca;
	
	private String vereda;
	
	private String tipoFormato;
	
	private List<RegistroDto> registros;

}

package co.com.ccarn.dtos;

import java.util.List;

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

	private String departamento;

	private String identificacionGanadero;

	private String municipio;

	private String nombreGanadero;

	private String nombrePredio;

	private String vereda;

	private List<DetalleTrazabilidadDto> detalleTrazabilidad;

}

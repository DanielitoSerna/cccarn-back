package co.com.ccarn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetalleTrazabilidadDto {
	
	private Integer id;

	private String codigoInterno;

	private String din;

	private String dinMadre;

	private String dinPadre;

	private String edad;

	private String numeroTrabajo;

	private String raza;

	private String sexo;

	private TrazabilidadDto trazabilidadBean;

}

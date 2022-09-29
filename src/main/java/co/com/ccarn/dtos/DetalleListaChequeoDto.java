package co.com.ccarn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleListaChequeoDto {

	private Integer id;

	private String calificacion;
	
	private String numeral;

	private String objetivo;

	private String tipoCriterio;

}

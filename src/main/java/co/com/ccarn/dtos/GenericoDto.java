package co.com.ccarn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenericoDto {

	private String tabla;

	private String orden;

	private String campoOrden;

	private String where;

	private int pagina;

	private int cantidad;

}

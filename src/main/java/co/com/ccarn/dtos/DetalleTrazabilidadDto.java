package co.com.ccarn.dtos;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	private Date fechaNacimiento;

	private String numeroTrabajo;

	private String raza;

	private String sexo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="trazabilidad")
	private TrazabilidadDto trazabilidadBean;

}

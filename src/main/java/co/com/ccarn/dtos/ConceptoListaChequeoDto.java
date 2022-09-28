package co.com.ccarn.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConceptoListaChequeoDto {

	private Integer id;

	private String concepto;

	private Integer criterioNoAplicaFundamental;

	private Integer criterioNoAplicaMayor;

	private Integer criterioNoAplicaMenor;

	private Integer criterioNoCumpleFundamental;

	private Integer criterioNoCumpleMayor;

	private Integer criterioNoCumpleMenor;

	private Integer criterioSiCumpleFundamental;

	private Integer criterioSiCumpleMayor;

	private Integer criterioSiCumpleMenor;

	private String nombreAtiende;

	private String nombreAuditoria;

	private String numeroIdentificacionAtiende;

	private String numeroIdentificacionAuditoria;

	private String observaciones;

	private Integer totalCriterioFundamental;

	private Integer totalCriterioMayor;

	private Integer totalCriterioMenor;

}

package co.com.ccarn.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetalleAndrologicoDto {

	private Integer id;

	private String capacidadParaMontar;

	private String circunferenciaEscrotal;

	private String colorFresco;

	private String colorPostDescongelacion;

	private String concentracionFresco;

	private String concentracionPostDescongelacion;

	private String condicionCorporal;

	private String electroeyaculador;

	private String eyaculacion;

	private Timestamp fechaNacimiento;

	private String informacionAnimal;

	private String integridadMembranaFresco;

	private String integridadMembranaPostDescongelacion;

	private String livido;

	private String movilidadMasalFresco;

	private String movilidadMasalPostDescongelacion;

	private String movilidadProgresivaFresco;

	private String movilidadProgresivaPostDescongelacion;

	private String movilidadTotalFresco;

	private String movilidadTotalPostDescongelacion;

	private String observaciones;

	private String olorFresco;

	private String olorPostDescongelacion;

	private String patasPezuñas;

	private String pene;

	private String phFresco;

	private String phPostDescongelacion;

	private String prepucio;

	private String prostata;

	private String protusion;

	private String raza;

	private String tarjetaProfesionalDos;

	private String tarjetaProfesionalUno;

	private String tecnicoResponsableDos;

	private String tecnicoResponsableUno;

	private String testiculos;

	private String vaginaArtificial;

	private String vesiculasSeminales;

	private String volumenFresco;

	private String volumenPostDescongelacion;

}

package co.com.ccarn.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="detalle_andrologico")
public class DetalleAndrologico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="capacidad_para_montar")
	private String capacidadParaMontar;
	
	@Column(name="circunferencia_escrotal")
	private String circunferenciaEscrotal;
	
	@Column(name="color_fresco")
	private String colorFresco;
	
	@Column(name="color_post_descongelacion")
	private String colorPostDescongelacion;
	
	@Column(name="concentracion_fresco")
	private String concentracionFresco;

	@Column(name="concentracion_post_descongelacion")
	private String concentracionPostDescongelacion;
	
	@Column(name="condicion_corporal")
	private String condicionCorporal;
	
	private String electroeyaculador;
	
	private String eyaculacion;
	
	@Column(name="fecha_nacimiento")
	private Timestamp fechaNacimiento;
	
	@Column(name="informacion_animal")
	private String informacionAnimal;
	
	@Column(name="integridad_membrana_fresco")
	private String integridadMembranaFresco;
	
	@Column(name="integridad_membrana_post_descongelacion")
	private String integridadMembranaPostDescongelacion;
	
	private String livido;
	
	@Column(name="movilidad_masal_fresco")
	private String movilidadMasalFresco;
	
	@Column(name="movilidad_masal_post_descongelacion")
	private String movilidadMasalPostDescongelacion;
	
	@Column(name="movilidad_progresiva_fresco")
	private String movilidadProgresivaFresco;
	
	@Column(name="movilidad_progresiva_post_descongelacion")
	private String movilidadProgresivaPostDescongelacion;
	
	@Column(name="movilidad_total_fresco")
	private String movilidadTotalFresco;
	
	@Column(name="movilidad_total_post_descongelacion")
	private String movilidadTotalPostDescongelacion;
	
	private String observaciones;
	
	@Column(name="olor_fresco")
	private String olorFresco;
	
	@Column(name="olor_post_descongelacion")
	private String olorPostDescongelacion;
	
	@Column(name="patas_pezuñas")
	private String patasPezuñas;
	
	private String pene;
	
	@Column(name="ph_fresco")
	private String phFresco;
	
	@Column(name="ph_post_descongelacion")
	private String phPostDescongelacion;
	
	private String prepucio;
	
	private String prostata;
	
	private String protusion;
	
	private String raza;
	
	@Column(name="tarjeta_profesional_dos")
	private String tarjetaProfesionalDos;
	
	@Column(name="tarjeta_profesional_uno")
	private String tarjetaProfesionalUno;
	
	@Column(name="tecnico_responsable_dos")
	private String tecnicoResponsableDos;
	
	@Column(name="tecnico_responsable_uno")
	private String tecnicoResponsableUno;
	
	private String testiculos;
	
	@Column(name="vagina_artificial")
	private String vaginaArtificial;
	
	@Column(name="vesiculas_seminales")
	private String vesiculasSeminales;
	
	@Column(name="volumen_fresco")
	private String volumenFresco;
	
	@Column(name="volumen_post_descongelacion")
	private String volumenPostDescongelacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="formato")
	private Formato formatoBean;

}

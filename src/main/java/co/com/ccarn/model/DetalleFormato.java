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
@Table(name="detalle_formato", schema = "ccarn")
public class DetalleFormato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="consideracion_final")
	private String consideracionFinal;
	
	private String deg;
	
	private String dx;
	
	private String embrion;
	
	@Column(name="empaque_embriones")
	private String empaqueEmbriones;
	private String er;
	private Timestamp fecha;
	private String g1;
	private String g2;
	private String g3;
	private String hora;
	
	@Column(name="hora_final")
	private String horaFinal;
	
	@Column(name="hora_inicio")
	private String horaInicio;
	
	private Integer iatf;
	
	@Column(name="medio_aspiracion")
	private String medioAspiracion;
	
	private String miv;
	
	@Column(name="nombre_donadora")
	private String nombreDonadora;
	
	@Column(name="nombre_identificacion")
	private String nombreIdentificacion;
	
	@Column(name="nombre_identificacion_receptora")
	private String nombreIdentificacionReceptora;
	
	@Column(name="nombre_identificacion_toro")
	private String nombreIdentificacionToro;
	
	@Column(name="nombre_toro")
	private String nombreToro;
	
	@Column(name="numero_identificacion")
	private String numeroIdentificacion;
	
	@Column(name="numero_identificacion_receptora")
	private String numeroIdentificacionReceptora;
	
	@Column(name="numero_identificacion_toro")
	private String numeroIdentificacionToro;
	
	@Column(name="numero_receptoras_seleccionadas")
	private String numeroReceptorasSeleccionadas;
	
	@Column(name="numero_receptoras_transfericas")
	private String numeroReceptorasTransfericas;
	
	@Column(name="numero_toro")
	private String numeroToro;
	
	private String observacion;
	
	@Column(name="observacion_folicular")
	private String observacionFolicular;
	
	private String ovario;
	
	private String p30;
	
	private String p60;
	
	private String programacion;
	
	@Column(name="raza_donadora")
	private String razaDonadora;
	
	@Column(name="raza_identificacion_receptora")
	private String razaIdentificacionReceptora;
	
	@Column(name="raza_identificacion_toro")
	private String razaIdentificacionToro;
	
	@Column(name="raza_toro")
	private String razaToro;
	
	private String receptora;
	
	private Integer seleccionada;
	
	private String sx;
	
	@Column(name="tarjeta_profesional_dos")
	private String tarjetaProfesionalDos;
	
	@Column(name="tarjeta_profesional_uno")
	private String tarjetaProfesionalUno;
	private Integer te;
	
	@Column(name="tecnico_responsable_dos")
	private String tecnicoResponsableDos;
	
	@Column(name="tecnico_responsable_uno")
	private String tecnicoResponsableUno;
	private String total;
	
	@Column(name="total_registros")
	private String totalRegistros;
	
	private String transferidor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="formato")
	private Formato formatoBean;

}

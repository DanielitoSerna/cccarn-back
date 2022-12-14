package co.com.ccarn.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formato", schema = "ccarn")
public class Formato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String departamento;
	
	private Date fecha;
	
	private String municipio;
	
	@Column(name="nombre_finca")
	private String nombreFinca;
	
	@Column(name="nombre_propietario")
	private String nombrePropietario;
	
	@Column(name="profesional_a_cargo_dos")
	private String profesionalACargoDos;
	
	@Column(name="profesional_a_cargo_uno")
	private String profesionalACargoUno;
	
	private String vereda;
	
	@Column(name="tipo_formato")
	private String tipoFormato;
	
	@Column(name = "profesional_produccion_invitro_embriones")
	private String profesionalProduccionInvitroEmbriones;
	
	@Column(name = "empaque_embriones")
	private String empaqueEmbriones;
	
	private String transferidor;
	
	@Column(name = "hora_inicio")
	private Timestamp horaInicio;
	
	@Column(name = "hora_final")
	private Timestamp horaFinal;
	
	@Column(name="tarjeta_profesional_dos")
	private String tarjetaProfesionalDos;
	
	@Column(name="tarjeta_profesional_uno")
	private String tarjetaProfesionalUno;
	
	@Column(name="tecnico_responsable_dos")
	private String tecnicoResponsableDos;
	
	@Column(name="tecnico_responsable_uno")
	private String tecnicoResponsableUno;
	
	@Column(name = "fecha_recomendacion")
	private Date fechaRecomendacion;
	
	@Column(name = "numero_visita")
	private String numeroVisita;
	
	@Column(name = "componente_asistencia_tecnica")
	private String componenteAsistenciaTecnica;
	
	private String recomendacion;
	
	@Column(name="medio_aspiracion")
	private String medioAspiracion;

	@Column(name="numero_receptoras_seleccionadas")
	private String numeroReceptorasSeleccionadas;
	
	@Column(name="numero_receptoras_transfericas")
	private String numeroReceptorasTransfericas;
	
	@JsonIgnore
	@OneToOne(mappedBy="formatoBean")
	private DetalleAndrologico detalleAndrologico;
	
	@JsonIgnore
	@OneToMany(mappedBy="formatoBean")
	private List<DetalleFormato> detalleFormatos;
	
}

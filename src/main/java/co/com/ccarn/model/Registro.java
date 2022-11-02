package co.com.ccarn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(schema = "ccarn")
public class Registro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="analisis_laboratorio")
	private String analisisLaboratorio;
	
	private String asistente;
	
	@Column(name="cantidad_fertilizacion")
	private String cantidadFertilizacion;
	
	@Column(name="cantidad_plaguicida")
	private String cantidadPlaguicida;
	
	@Column(name="carencia_plaguicida")
	private String carenciaPlaguicida;
	
	private String diagnostico;
	
	private String dictada;
	
	private String dosis;
	
	private String duracion;
	
	@Column(name="duracion_tratamiento")
	private String duracionTratamiento;
	
	private String enfermedad;
	
	private String entradas;
	
	@Column(name="estado_palpacion_p")
	private String estadoPalpacionP;
	
	@Column(name="estado_palpacion_v")
	private String estadoPalpacionV;
	
	private String existencias;
	
	@Column(name="fecha_alimento")
	private Date fechaAlimento;
	
	@Column(name="fecha_aplicacion")
	private Date fechaAplicacion;
	
	@Column(name="fecha_calores")
	private Date fechaCalores;
	
	@Column(name="fecha_capacitacion")
	private Date fechaCapacitacion;
	
	@Column(name="fecha_diagnostico")
	private Date fechaDiagnostico;
	
	@Column(name="fecha_fertilizacion")
	private Date fechaFertilizacion;
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name="fecha_ingreso_persona")
	private Date fechaIngresoPersona;
	
	@Column(name="fecha_inicio_tratamiento")
	private Date fechaInicioTratamiento;
	
	@Column(name="fecha_medicamento")
	private Date fechaMedicamento;
	
	@Column(name="fecha_palpacion")
	private Date fechaPalpacion;
	
	@Column(name="fecha_plaguicida")
	private Date fechaPlaguicida;
	
	@Column(name="fecha_salida")
	private Date fechaSalida;
	
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name="grado_toxicidad")
	private String gradoToxicidad;
	
	@Column(name="id_animal")
	private String idAnimal;
	
	@Column(name="identificacion_cria")
	private String identificacionCria;
	
	@Column(name="identificacion_ingreso_persona")
	private String identificacionIngresoPersona;
	
	private String insectos;
	
	private String laboratorio;
	
	private String lote;
	
	@Column(name="lugar_aplicacion")
	private String lugarAplicacion;
	
	@Column(name="motivo_visita")
	private String motivoVisita;
	
	private String muerte;
	
	@Column(name="nombre_ingreso_persona")
	private String nombreIngresoPersona;
	
	@Column(name="nombre_medicamento")
	private String nombreMedicamento;
	
	@Column(name="nombre_toro_empleado")
	private String nombreToroEmpleado;

	@Column(name="numero_animales")
	private String numeroAnimales;
	
	private String observaciones;
	
	@Column(name="palpacion_cc")
	private String palpacionCc;
	
	@Column(name="palpacion_estov")
	private String palpacionEstov;
	
	@Column(name="parto_probable")
	private Date partoProbable;
	
	@Column(name="parto_real")
	private Date partoReal;
	
	@Column(name="periodo_descanso")
	private String periodoDescanso;
	
	@Column(name="procedencia_ingreso_persona")
	private String procedenciaIngresoPersona;
	
	private String producto;
	
	@Column(name="producto_fertilizacion")
	private String productoFertilizacion;
	
	@Column(name="producto_plaguicida")
	private String productoPlaguicida;
	
	@Column(name="registro_ica")
	private String registroIca;
	
	private String responsable;
	
	@Column(name="responsable_aplicacion")
	private String responsableAplicacion;
	
	@Column(name="responsable_diagnostico")
	private String responsableDiagnostico;
	
	private String roedores;
	
	private String saldo;
	
	private String salidas;
	
	@Column(name="servicio_no")
	private String servicioNo;
	
	@Column(name="servicio_si_ia")
	private String servicioSiIa;
	
	@Column(name="servicio_si_mn")
	private String servicioSiMn;
	
	@Column(name="sexo_cria_h")
	private String sexoCriaH;
	
	@Column(name="sexo_cria_m")
	private String sexoCriaM;
	
	@Column(name="telefono_ingreso_persona")
	private String telefonoIngresoPersona;
	
	@Column(name="tema_capacitacion")
	private String temaCapacitacion;
	
	@Column(name="tiempo_retiro")
	private String tiempoRetiro;
	
	private String uso;
	
	@Column(name="via_aplicacion")
	private String viaAplicacion;
	
	@ManyToOne
	@JoinColumn(name="encabezado_registro")
	private EncabezadoRegistro encabezadoRegistroBean;

}

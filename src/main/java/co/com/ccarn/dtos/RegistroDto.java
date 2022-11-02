package co.com.ccarn.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistroDto {
	
	private Integer id;
	
	private String analisisLaboratorio;
	
	private String asistente;
	
	private String cantidadFertilizacion;
	
	private String cantidadPlaguicida;
	
	private String carenciaPlaguicida;
	
	private String diagnostico;
	
	private String dictada;
	
	private String dosis;
	
	private String duracion;
	
	private String duracionTratamiento;
	
	private String enfermedad;
	
	private String entradas;
	
	private String estadoPalpacionP;
	
	private String estadoPalpacionV;
	
	private String existencias;
	
	private Date fechaAlimento;
	
	private Date fechaAplicacion;
	
	private Date fechaCalores;
	
	private Date fechaCapacitacion;
	
	private Date fechaDiagnostico;
	
	private Date fechaFertilizacion;
	
	private Date fechaIngreso;
	
	private Date fechaIngresoPersona;
	
	private Date fechaInicioTratamiento;
	
	private Date fechaMedicamento;
	
	private Date fechaPalpacion;
	
	private Date fechaPlaguicida;
	
	private Date fechaSalida;
	
	private Date fechaVencimiento;
	
	private String gradoToxicidad;
	
	private String idAnimal;
	
	private String identificacionCria;
	
	private String identificacionIngresoPersona;
	
	private String insectos;
	
	private String laboratorio;
	
	private String lote;
	
	private String lugarAplicacion;
	
	private String motivoVisita;
	
	private String muerte;
	
	private String nombreIngresoPersona;
	
	private String nombreMedicamento;
	
	private String nombreToroEmpleado;
	
	private String numeroAnimales;
	
	private String observaciones;
	
	private String palpacionCc;
	
	private String palpacionEstov;
	
	private Date partoProbable;
	
	private Date partoReal;
	
	private String periodoDescanso;
	
	private String procedenciaIngresoPersona;
	
	private String producto;
	
	private String productoFertilizacion;
	
	private String productoPlaguicida;
	
	private String registroIca;
	
	private String responsable;
	
	private String responsableAplicacion;
	
	private String responsableDiagnostico;
	
	private String roedores;
	
	private String saldo;
	
	private String salidas;
	
	private String servicioNo;
	
	private String servicioSiIa;
	
	private String servicioSiMn;
	
	private String sexoCriaH;
	
	private String sexoCriaM;
	
	private String telefonoIngresoPersona;
	
	private String temaCapacitacion;
	
	private String tiempoRetiro;
	
	private String uso;
	
	private String viaAplicacion;

}

package co.com.ccarn.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "caracterizacion", schema = "ccarn")
public class Caracterizacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="acta_compromiso")
	private Boolean actaCompromiso;

	private Boolean afrodescendiente;

	@Column(name="alimentacion_animal")
	private String alimentacionAnimal;

	@Column(name="anio_participa_gobernacion")
	private String anioParticipaGobernacion;

	@Column(name="anio_participa_ministerio_agricultura")
	private String anioParticipaMinisterioAgricultura;

	@Column(name="asistencia_tecnica")
	private Boolean asistenciaTecnica;

	private String asnm;

	@Column(name="asociado_agremiacion")
	private Boolean asociadoAgremiacion;

	@Column(name="biotecnologia_reproduccion")
	private String biotecnologiaReproduccion;

	@Column(name="buenas_practicas_ganaderas")
	private String buenasPracticasGanaderas;

	@Column(name="buenas_practicas_ordeno")
	private String buenasPracticasOrdeno;

	@Column(name="cargo_dentro_predio")
	private String cargoDentroPredio;

	private String carne;

	private String celular;

	@Column(name="celular_encuestado")
	private String celularEncuestado;

	@Column(name="correo_electronico")
	private String correoElectronico;

	@Column(name="correo_electronico_encuestado")
	private String correoElectronicoEncuestado;

	@Column(name="costo_produccion_animales")
	private Boolean costoProduccionAnimales;

	private String departamento;

	@Column(name="descripcion_suplementa")
	private String descripcionSuplementa;

	private Boolean desmovilizado;

	private Boolean discapacitado;

	@Column(name="distancia_predio_cabecera_municipal")
	private String distanciaPredioCabeceraMunicipal;

	@Column(name="doble_proposito")
	private String dobleProposito;

	private String edad;

	private String escolaridad;

	@Column(name="estado_civil")
	private String estadoCivil;

	@Column(name="estado_via_acceso")
	private String estadoViaAcceso;

	private Date fecha;

	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="final_ceba")
	private String finalCeba;

	@Column(name="finca_certificada")
	private Boolean fincaCertificada;

	@Column(name="finca_proceso_certificacion")
	private Boolean fincaProcesoCertificacion;

	private String genero;

	@Column(name="gestion_administrativa")
	private String gestionAdministrativa;

	@Column(name="humedad_relativa")
	private String humedadRelativa;

	private Boolean iatf;

	private String identificacion;

	private Boolean indigena;

	@Column(name="informacion_tecnica_primaria")
	private String informacionTecnicaPrimaria;

	@Column(name="inicio_ceba")
	private String inicioCeba;

	private BigDecimal latitud;

	private BigDecimal longitud;

	@Column(name="mapa_finca")
	private Boolean mapaFinca;

	@Column(name="mejoramiento_genetico")
	private String mejoramientoGenetico;

	private String municipio;

	private String nombre;

	@Column(name="nombre_encuestado")
	private String nombreEncuestado;

	@Column(name="nombre_entidad")
	private String nombreEntidad;

	@Column(name="nombre_predio")
	private String nombrePredio;

	@Column(name="nombre_propietario")
	private String nombrePropietario;

	@Column(name="nombre_software")
	private String nombreSoftware;

	@Column(name="numero_caracterizaacion")
	private String numeroCaracterizaacion;

	@Column(name="numero_novillo_iatf")
	private String numeroNovilloIatf;
	
	@Column(name="numero_novillo_te")
	private String numeroNovilloTe;

	@Column(name="numero_vacas_iatf")
	private String numeroVacasIatf;
	
	@Column(name="numero_vacas_te")
	private String numeroVacasTe;
	
	@Column(name = "numero_identificacion")
	private String numeroIdentificacion;

	private String otro;

	@Column(name="parametros_tecnicos")
	private Boolean parametrosTecnicos;

	@Column(name="participa_componente_biotecnologia")
	private Boolean participaComponenteBiotecnologia;

	@Column(name="participa_proyecto_anterior_gobernacion")
	private Boolean participaProyectoAnteriorGobernacion;

	@Column(name="participa_proyecto_anterior_ministerio_agricultura")
	private Boolean participaProyectoAnteriorMinisterioAgricultura;

	private String parto;

	@Column(name="patos_forrajes")
	private String patosForrajes;

	@Column(name="peso_destete")
	private String pesoDestete;

	@Column(name="peso_nacimiento")
	private String pesoNacimiento;

	@Column(name="peso_primer_servicio")
	private String pesoPrimerServicio;

	@Column(name="profesional_cargo_asesoria_directa")
	private String profesionalCargoAsesoriaDirecta;

	@Column(name="raza_hato")
	private String razaHato;

	@Column(name="responsable_informacion_empresa")
	private String responsableInformacionEmpresa;

	@Column(name="sanidad_animal")
	private String sanidadAnimal;

	@Column(name="sede_municipio")
	private String sedeMunicipio;

	private Boolean suplementa;

	@Column(name="tarjeta_profesional_dos")
	private String tarjetaProfesionalDos;

	@Column(name="tarjeta_profesional_uno")
	private String tarjetaProfesionalUno;

	private Boolean te;

	@Column(name="tecnico_responsable_dos")
	private String tecnicoResponsableDos;

	@Column(name="tecnico_responsable_uno")
	private String tecnicoResponsableUno;

	@Column(name="telefono_encuestado")
	private String telefonoEncuestado;

	@Column(name="telefono_fijo")
	private String telefonoFijo;

	@Column(name="tenencia_predio")
	private String tenenciaPredio;

	@Column(name="tiene_computador")
	private Boolean tieneComputador;

	@Column(name="tiene_internet")
	private Boolean tieneInternet;

	private String tipo;

	@Column(name="tipo_entidad")
	private String tipoEntidad;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	@Column(name="tipo_pasto_predio")
	private String tipoPastoPredio;

	@Column(name="tipo_produccion")
	private String tipoProduccion;

	private String topografia;

	@Column(name="usa_software")
	private Boolean usaSoftware;

	private String vereda;

	private Boolean victima;

}

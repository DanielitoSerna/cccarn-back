package co.com.ccarn.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lista_chequeo", schema = "ccarn")
public class ListaChequeo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="area_total_predio")
	private String areaTotalPredio;
	
	@Column(name="aves_corral")
	private String avesCorral;
	
	private String bovinos;
	
	private String bufalinos;
	
	private String caprinos;
	
	private String ceba;
	
	@Column(name="ciclo_completo")
	private String cicloCompleto;
	
	private String conejos;
	
	@Column(name="correo_electronico_propietario")
	private String correoElectronicoPropietario;
	
	@Column(name="correo_electronico_responsable")
	private String correoElectronicoResponsable;
	
	private String cria;
	
	private String departamento;
	
	private String equidos;
	
	private String especie;
	
	private Timestamp fecha;
	
	@Column(name="fecha_auditoria")
	private Timestamp fechaAuditoria;
	
	private String latitud;
	
	private String leche;
	
	private String levante;
	
	private String longitud;
	
	@Column(name="material_genetico")
	private String materialGenetico;
	
	private String municipio;
	
	private Integer mv;
	
	private Integer mvz;
	
	@Column(name="nombre_propietario")
	private String nombrePropietario;
	
	@Column(name = "nombre_predio")
	private String nombrePredio;
	
	@Column(name="numero_identificacion")
	private String numeroIdentificacion;
	
	@Column(name="numero_matricula")
	private String numeroMatricula;
	
	@Column(name="numero_registro_predio")
	private String numeroRegistroPredio;
	
	@Column(name="numero_rspp_ispp")
	private String numeroRsppIspp;
	
	private String objeto;
	
	private String otro;
	
	private String ovinos;
	
	@Column(name="peces_cultivo")
	private String pecesCultivo;
	
	private String porcinos;
	
	private String postura;
	
	@Column(name="responsable_manejo_sanitario")
	private String responsableManejoSanitario;
	
	@Column(name="telefono_propietario")
	private String telefonoPropietario;
	
	@Column(name="telefono_responsable")
	private String telefonoResponsable;
	
	@Column(name="tipo_visita")
	private String tipoVisita;
	
	@Column(name = "total_animales")
	private String totalAnimales;
	
	private String vereda;
	
	private String zoocria;
	
	@Column(name="tipo_formato")
	private String tipoFormato;
	
	@OneToMany(mappedBy="listaChequeoBean")
	private List<ConceptoListaChequeo> conceptoListaChequeos;
	
	@OneToMany(mappedBy="listaChequeoBean")
	private List<DetalleListaChequeo> detalleListaChequeos;
	
}

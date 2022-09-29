package co.com.ccarn.model;

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
@Table(name="concepto_lista_chequeo", schema = "ccarn")
public class ConceptoListaChequeo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String concepto;
	
	@Column(name="criterio_no_aplica_fundamental")
	private Integer criterioNoAplicaFundamental;
	
	@Column(name="criterio_no_aplica_mayor")
	private Integer criterioNoAplicaMayor;
	
	@Column(name="criterio_no_aplica_menor")
	private Integer criterioNoAplicaMenor;
	
	@Column(name="criterio_no_cumple_fundamental")
	private Integer criterioNoCumpleFundamental;
	
	@Column(name="criterio_no_cumple_mayor")
	private Integer criterioNoCumpleMayor;
	
	@Column(name="criterio_no_cumple_menor")
	private Integer criterioNoCumpleMenor;
	
	@Column(name="criterio_si_cumple_fundamental")
	private Integer criterioSiCumpleFundamental;
	
	@Column(name="criterio_si_cumple_mayor")
	private Integer criterioSiCumpleMayor;
	
	@Column(name="criterio_si_cumple_menor")
	private Integer criterioSiCumpleMenor;
	
	@Column(name = "especies_existentes_predio_aplica_concepto")
	private String especiesExistentesPredioAplicaConcepto;
	
	@Column(name="nombre_atiende")
	private String nombreAtiende;
	
	@Column(name = "nombre_atiende_dos")
	private String nombreAtiendeDos;
	
	@Column(name="nombre_auditoria")
	private String nombreAuditoria;
	
	@Column(name="numero_identificacion_atiende")
	private String numeroIdentificacionAtiende;
	
	@Column(name = "numero_identificacion_atiende_dos")
	private String numeroIdentificacionAtiendeDos;
	
	@Column(name="numero_identificacion_auditoria")
	private String numeroIdentificacionAuditoria;
	
	private String observaciones;
	
	@Column(name="total_criterio_fundamental")
	private Integer totalCriterioFundamental;
	
	@Column(name="total_criterio_mayor")
	private Integer totalCriterioMayor;
	
	@Column(name="total_criterio_menor")
	private Integer totalCriterioMenor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lista_chequeo")
	private ListaChequeo listaChequeoBean;
	
}

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
@Table(name = "detalle_lista_chequeo", schema = "ccarn")
public class DetalleListaChequeo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String calificacion;
	
	private String numeral;
	
	private String objetivo;
	
	@Column(name="tipo_criterio")
	private String tipoCriterio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="lista_chequeo")
	private ListaChequeo listaChequeoBean;

}

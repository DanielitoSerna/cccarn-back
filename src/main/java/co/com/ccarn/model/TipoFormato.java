package co.com.ccarn.model;

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
@Table(name="tipo_formato")
public class TipoFormato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_formato")
	private String nombreFormato;
	
	@OneToMany(mappedBy="tipoFormatoBean")
	private List<Formato> formatos;
	
	@OneToMany(mappedBy="tipoFormatoBean")
	private List<ListaChequeo> listaChequeos;

}

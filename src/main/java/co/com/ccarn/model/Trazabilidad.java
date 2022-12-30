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
@Table(schema = "ccarn")
public class Trazabilidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String departamento;

	@Column(name="identificacion_ganadero")
	private String identificacionGanadero;

	private String municipio;

	@Column(name="nombre_ganadero")
	private String nombreGanadero;

	@Column(name="nombre_predio")
	private String nombrePredio;

	private String vereda;

	//bi-directional many-to-one association to DetalleTrazabiidad
	@OneToMany(mappedBy="trazabilidadBean")
	private List<DetalleTrazabilidad> detalleTrazabilidad;

}

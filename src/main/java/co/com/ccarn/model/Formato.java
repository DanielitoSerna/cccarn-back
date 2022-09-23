package co.com.ccarn.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String departamento;
	
	private Timestamp fecha;
	
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
	
	@OneToMany(mappedBy="formatoBean")
	private List<DetalleAndrologico> detalleAndrologicos;
	
	@OneToMany(mappedBy="formatoBean")
	private List<DetalleFormato> detalleFormatos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_formato")
	private TipoFormato tipoFormatoBean;

}

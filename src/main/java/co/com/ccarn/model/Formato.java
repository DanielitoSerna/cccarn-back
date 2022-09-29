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
@Table(name = "formato", schema = "ccarn")
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
	
	@Column(name="tipo_formato")
	private String tipoFormato;
	
	@OneToMany(mappedBy="formatoBean")
	private List<DetalleAndrologico> detalleAndrologicos;
	
	@OneToMany(mappedBy="formatoBean")
	private List<DetalleFormato> detalleFormatos;
	
}

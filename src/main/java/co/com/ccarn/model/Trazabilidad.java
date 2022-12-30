package co.com.ccarn.model;

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
@Table(schema = "ccarn")
public class Trazabilidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="codigo_interno")
	private String codigoInterno;

	private String departamento;

	private String din;

	@Column(name="din_madre")
	private String dinMadre;

	@Column(name="din_padre")
	private String dinPadre;

	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="identificacion_ganadero")
	private String identificacionGanadero;

	private String municipio;

	@Column(name="nombre_ganadero")
	private String nombreGanadero;

	@Column(name="nombre_predio")
	private String nombrePredio;

	@Column(name="numero_trabajo")
	private String numeroTrabajo;

	private String raza;

	private String sexo;

	private String vereda;

}

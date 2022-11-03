package co.com.ccarn.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="encabezado_registro", schema = "ccarn")
public class EncabezadoRegistro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String chapeta;
	
	private String departamento;
	
	@Column(name="empresa_ganadera")
	private String empresaGanadera;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	private String madre;
	
	private String medicamento;
	
	private String municipio;
	
	@Column(name="nombre_comercial")
	private String nombreComercial;
	
	@Column(name="origen_proveedor")
	private String origenProveedor;
	
	private String padre;
	
	private String potrero;
	
	private String propietario;
	
	private String raza;
	
	@Column(name="registro_ica")
	private String registroIca;
	
	@Column(name="tipo_alimento")
	private String tipoAlimento;
	
	private String vaca;
	
	private String vereda;
	
	@Column(name = "tipo_formato")
	private String tipoFormato;
	
	@JsonIgnore
	@OneToMany(mappedBy="encabezadoRegistroBean")
	private List<Registro> registros;

}

package co.com.ccarn.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListaChequeoDto {

	private Integer id;

	private String areaTotalPredio;

	private String avesCorral;

	private String bovinos;

	private String bufalinos;

	private String caprinos;

	private String ceba;

	private String cicloCompleto;

	private String conejos;

	private String correoElectronicoPropietario;

	private String correoElectronicoResponsable;

	private String cria;

	private String departamento;

	private String equidos;

	private String especie;

	private Date fecha;

	private Date fechaAuditoria;

	private BigDecimal latitud;

	private String leche;

	private String levante;

	private BigDecimal longitud;

	private String materialGenetico;

	private String municipio;

	private Boolean mv;

	private Boolean mvz;

	private String nombrePropietario;
	
	private String nombrePredio;

	private String numeroIdentificacion;

	private String numeroMatricula;

	private String numeroRegistroPredio;

	private String numeroRsppIspp;

	private String objeto;

	private String otro;

	private String ovinos;

	private String pecesCultivo;

	private String porcinos;

	private String postura;

	private String responsableManejoSanitario;

	private String telefonoPropietario;

	private String telefonoResponsable;

	private String tipoVisita;

	private String vereda;

	private String zoocria;
	
	private String tipoFormato;
	
	private String totalAnimales;
	
	private ConceptoListaChequeoDto concepto;
	
	private List<DetalleListaChequeoDto> detalle;

}

package co.com.ccarn.dtos;

import java.sql.Timestamp;
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
public class FormatoDto {

	private Integer id;

	private String departamento;

	private Date fecha;

	private String municipio;

	private String nombreFinca;

	private String nombrePropietario;

	private String profesionalACargoDos;

	private String profesionalACargoUno;

	private String vereda;

	private String tipoFormato;

	private String profesionalProduccionInvitroEmbriones;

	private String empaqueEmbriones;

	private String transferidor;

	private Timestamp horaInicio;

	private Timestamp horaFinal;

	private String tarjetaProfesionalDos;

	private String tarjetaProfesionalUno;

	private String tecnicoResponsableDos;

	private String tecnicoResponsableUno;

	private Date fechaRecomendacion;

	private String numeroVisita;

	private String componenteAsistenciaTecnica;

	private String recomendacion;
	
	private String numeroReceptorasSeleccionadas;

	private String numeroReceptorasTransfericas;
	
	private String medioAspiracion;

	private DetalleAndrologicoDto detalleAndrologico;

	private List<DetalleFormatoDto> detalleFormatos;

}

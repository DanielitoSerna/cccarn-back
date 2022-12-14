package co.com.ccarn.dtos;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleFormatoDto {

	private Integer id;

	private String consideracionFinal;

	private String deg;

	private String dx;

	private String embrion;

	private String er;

	private Date fecha;

	private String g1;

	private String g2;

	private String g3;

	private Timestamp hora;

	private String iatf;

	private String miv;

	private String nombreDonadora;

	private String nombreIdentificacion;

	private String nombreIdentificacionReceptora;

	private String nombreIdentificacionToro;

	private String nombreToro;

	private String numeroIdentificacion;

	private String numeroIdentificacionReceptora;

	private String numeroIdentificacionToro;

	private String numeroToro;

	private String observacion;

	private String observacionFolicular;

	private String ovario;

	private String p30;

	private String p60;

	private String programacion;

	private String razaDonadora;

	private String razaIdentificacionReceptora;

	private String razaIdentificacionToro;

	private String razaToro;

	private String receptora;

	private Integer seleccionada;

	private String sx;

	private String te;

	private String total;

	private String totalRegistros;

	private String color;

	private Integer edadMeses;

	private Integer numeroPartos;

	private String an;

	private String cp;
	
	private String hallazgo;

	private FormatoDto formatoBean;

}

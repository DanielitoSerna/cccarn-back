package co.com.ccarn.excel;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.com.ccarn.model.Caracterizacion;

public class ExcelGeneratorCaracterizacion {

	private List<Caracterizacion> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelGeneratorCaracterizacion(List<Caracterizacion> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Caracterizacion");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "# Registro", style);
		createCell(row, 1, "Fecha de la Caracterización", style);
		createCell(row, 2, "Número Caracterización", style);
		createCell(row, 3, "Nombre del Propietario", style);
		createCell(row, 4, "Tipo de Identificación", style);
		createCell(row, 5, "Número de Identificación", style);
		createCell(row, 6, "Departamento", style);
		createCell(row, 7, "Municipio", style);
		createCell(row, 8, "Nombre del Predio", style);
		createCell(row, 9, "Vereda", style);
		createCell(row, 10, "Correo Electrónico", style);
		createCell(row, 11, "Teléfono", style);
		createCell(row, 12, "Celular", style);
		createCell(row, 13, "Acta de Compromiso", style);
		createCell(row, 14, "Asociado de Alguna Agremiación", style);
		createCell(row, 15, "Tipo Agremiación", style);
		createCell(row, 16, "Nombre Agremiación", style);
		createCell(row, 17, "Sede - Municipio", style);
		createCell(row, 18, "Escolaridad", style);
		createCell(row, 19, "Género", style);
		createCell(row, 20, "Estado Civil", style);
		createCell(row, 21, "Fecha de Nacimiento", style);
		createCell(row, 22, "Edad", style);
		createCell(row, 23, "Afrodescendiente", style);
		createCell(row, 24, "Indígena", style);
		createCell(row, 25, "Discapacitado", style);
		createCell(row, 26, "Víctima", style);
		createCell(row, 27, "Desmovilizado", style);
		createCell(row, 28, "Nombre del Encuestado", style);
		createCell(row, 29, "Identificación", style);
		createCell(row, 30, "Cargo Dentro del Predio", style);
		createCell(row, 31, "Correo Electrónico del Encuestado", style);
		createCell(row, 32, "Profesional a Cargo de la Asesoría Directa", style);
		createCell(row, 33, "Teléfono del Encuestado", style);
		createCell(row, 34, "Celular del Encuestado", style);
		createCell(row, 35, "Participa en el Componente de Biotecnología", style);
		createCell(row, 36, "IATF", style);
		createCell(row, 37, "Número de vacas", style);
		createCell(row, 38, "Número de novillos", style);
		createCell(row, 39, "TE", style);
		createCell(row, 40, "Número de vacas", style);
		createCell(row, 41, "Número de novillos", style);
		createCell(row, 42, "Raza que Requiere para su Hato", style);
		createCell(row, 43, "Doble Propósito", style);
		createCell(row, 44, "Carne", style);
		createCell(row, 45, "Latitud", style);
		createCell(row, 46, "Longitud", style);
		createCell(row, 47, "ASNM", style);
		createCell(row, 48, "Humedad Relativa", style);
		createCell(row, 49, "Topografía", style);
		createCell(row, 50, "Tenencia del Predio", style);
		createCell(row, 51, "Distancia del Predio (KMS)", style);
		createCell(row, 52, "Tiene Mapa de la Finca", style);
		createCell(row, 53, "Estados de las Vías de Acceso", style);
		createCell(row, 54, "Dispone de Computador para Llevar la Información de la Empresa", style);
		createCell(row, 55, "Dispone de Internet en su Finca", style);
		createCell(row, 56, "Utiliza Algún Software Para el Manejo de la Información del Predio", style);
		createCell(row, 57, "Nombre Software", style);
		createCell(row, 58, "Cómo Lleva la Información Técnica de la Empresa", style);
		createCell(row, 59, "Quién Lleva la Información de la Empresa", style);
		createCell(row, 60, "La Finca Está Certificada", style);
		createCell(row, 61, "La Finca se Encuentra en Proceso de Certificación", style);
		createCell(row, 62, "Conoce sus Parámetros Técnicos", style);
		createCell(row, 63, "Conoce el Costo de Producción de los Animales", style);
		createCell(row, 64, "Tipo de Producción", style);
		createCell(row, 65, "Peso al Nacimiento", style);
		createCell(row, 66, "Peso al Destete", style);
		createCell(row, 67, "Peso al Primer Servicio", style);
		createCell(row, 68, "Parto", style);
		createCell(row, 69, "Inicio de la Ceba", style);
		createCell(row, 70, "Final de la Ceba", style);
		createCell(row, 71, "Asistencia Técnica", style);
		createCell(row, 72, "Tipo de Entidad", style);
		createCell(row, 73, "Ha Participado en Proyectos Anteriores con la Gobernación", style);
		createCell(row, 74, "Años en el que Participó", style);
		createCell(row, 75, "Ha participado en Proyectos Anteriores con el Ministerio de Agricultura", style);
		createCell(row, 76, "Años en el que Participó", style);
		createCell(row, 77, "Nombre de la Entidad", style);
		createCell(row, 78, "Mejoramiento Genético", style);
		createCell(row, 79, "Patos y Forrajes", style);
		createCell(row, 80, "Alimentación Animal", style);
		createCell(row, 81, "Buenas Prácticas Ganaderas", style);
		createCell(row, 82, "Otro", style);
		createCell(row, 83, "Sanidad Animal", style);
		createCell(row, 84, "Gestión Administrativa", style);
		createCell(row, 85, "Buenas Prácticas de Ordeño", style);
		createCell(row, 86, "Biotecnología de la Reproducción", style);
		createCell(row, 87, "Tipo de Pastos en el Predio", style);
		createCell(row, 88, "Suplementa", style);
		createCell(row, 89, "Tipo Suplemento", style);
		createCell(row, 90, "Técnico Responsable", style);
		createCell(row, 91, "Tarjeta Profesional", style);
		createCell(row, 92, "Técnico Responsable", style);
		createCell(row, 93, "Tarjeta Profesional", style);
	}

	private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (valueOfCell instanceof Integer) {
			cell.setCellValue((Integer) valueOfCell);
		} else if (valueOfCell instanceof Long) {
			cell.setCellValue((Long) valueOfCell);
		} else if (valueOfCell instanceof String) {
			cell.setCellValue((String) valueOfCell);
		} else if (valueOfCell instanceof Timestamp) {
			cell.setCellValue((Timestamp) valueOfCell);
		} 
		else {
			cell.setCellValue((Boolean) valueOfCell);
		}
		cell.setCellStyle(style);
	}

	private void write() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		for (Caracterizacion record : lista) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style);
			createCell(row, columnCount++, record.getFecha() != null ? dateFormatter.format(record.getFecha()) : ""  , style);
			createCell(row, columnCount++, record.getNumeroCaracterizaacion() != null ? record.getNumeroCaracterizaacion() : "", style);
			createCell(row, columnCount++, record.getNombrePropietario() != null ? record.getNombrePropietario() : "", style);
			createCell(row, columnCount++, record.getTipoIdentificacion() != null ? record.getTipoIdentificacion() : "", style);
			createCell(row, columnCount++, record.getIdentificacion() != null ? record.getIdentificacion() : "", style);
			createCell(row, columnCount++, record.getDepartamento() != null ? record.getDepartamento() : "", style);
			createCell(row, columnCount++, record.getMunicipio() != null ? record.getMunicipio() : "", style);
			createCell(row, columnCount++, record.getNombrePredio() != null ? record.getNombrePredio() : "", style);
			createCell(row, columnCount++, record.getVereda() != null ? record.getVereda() : "", style);
			createCell(row, columnCount++, record.getCorreoElectronico() != null ? record.getCorreoElectronico() : "", style);
			createCell(row, columnCount++, record.getTelefonoFijo() != null ? record.getTelefonoFijo() : "", style);
			createCell(row, columnCount++, record.getCelular() != null ? record.getCelular() : "", style);
			createCell(row, columnCount++, record.getActaCompromiso() != null ? Boolean.TRUE.equals(record.getActaCompromiso()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getAsociadoAgremiacion() != null ? Boolean.TRUE.equals(record.getAsociadoAgremiacion()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getTipo() != null ? record.getTipo() : "", style);
			createCell(row, columnCount++, record.getNombre() != null ? record.getNombre() : "", style);
			createCell(row, columnCount++, record.getSedeMunicipio() != null ? record.getSedeMunicipio() : "", style);
			createCell(row, columnCount++, record.getEscolaridad() != null ? record.getEscolaridad() : "", style);
			createCell(row, columnCount++, record.getGenero() != null ? record.getGenero() : "", style);
			createCell(row, columnCount++, record.getEstadoCivil() != null ? record.getEstadoCivil() : "", style);
			createCell(row, columnCount++, record.getFechaNacimiento() != null ? dateFormatter.format(record.getFechaNacimiento()) : ""  , style);
			createCell(row, columnCount++, record.getEdad() != null ? record.getEdad() : "", style);
			createCell(row, columnCount++, record.getAfrodescendiente() != null ? Boolean.TRUE.equals(record.getAfrodescendiente()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getIndigena() != null ? Boolean.TRUE.equals(record.getIndigena()) ? "SI" : "NO" : "NO", style);
			createCell(row, columnCount++, record.getDiscapacitado() != null ? Boolean.TRUE.equals(record.getDiscapacitado()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getVictima() != null ? Boolean.TRUE.equals(record.getVictima()) ? "SI" : "NO" : "NO", style);
			createCell(row, columnCount++, record.getDesmovilizado() != null ? Boolean.TRUE.equals(record.getDesmovilizado()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getNombreEncuestado() != null ? record.getNombreEncuestado() : "", style);
			createCell(row, columnCount++, record.getIdentificacion() != null ? record.getIdentificacion() : "", style);
			createCell(row, columnCount++, record.getCargoDentroPredio() != null ? record.getCargoDentroPredio() : "", style);
			createCell(row, columnCount++, record.getCorreoElectronicoEncuestado() != null ? record.getCorreoElectronicoEncuestado() : "", style);
			createCell(row, columnCount++, record.getProfesionalCargoAsesoriaDirecta() != null ? record.getProfesionalCargoAsesoriaDirecta() : "", style);
			createCell(row, columnCount++, record.getTelefonoEncuestado() != null ? record.getTelefonoEncuestado() : "", style);
			createCell(row, columnCount++, record.getCelularEncuestado() != null ? record.getCelularEncuestado() : "", style);
			createCell(row, columnCount++, record.getParticipaComponenteBiotecnologia() != null ? Boolean.TRUE.equals(record.getParticipaComponenteBiotecnologia()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, (record.getNumeroVacasIatf() != null || record.getNumeroNovilloIatf() != null) ? "SI" : "NO", style);
			createCell(row, columnCount++, record.getNumeroVacasIatf() != null ? record.getNumeroVacasIatf() : "", style);
			createCell(row, columnCount++, record.getNumeroNovilloIatf() != null ? record.getNumeroNovilloIatf() : "", style);
			createCell(row, columnCount++, (record.getNumeroNovilloTe() != null || record.getNumeroVacasTe() != null) ? "SI" : "NO", style);
			createCell(row, columnCount++, record.getNumeroVacasTe() != null ? record.getNumeroVacasTe() : "", style);
			createCell(row, columnCount++, record.getNumeroNovilloTe() != null ? record.getNumeroNovilloTe() : "", style);
			createCell(row, columnCount++, record.getRazaHato() != null ? record.getRazaHato() : "", style);
			createCell(row, columnCount++, record.getDobleProposito() != null ? record.getDobleProposito() : "", style);
			createCell(row, columnCount++, record.getCarne() != null ? record.getCarne() : "", style);
			createCell(row, columnCount++, record.getLatitud() != null ? record.getLatitud().toString() : "", style);
			createCell(row, columnCount++, record.getLongitud() != null ? record.getLongitud().toString() : "", style);
			createCell(row, columnCount++, record.getAsnm() != null ? record.getAsnm() : "", style);
			createCell(row, columnCount++, record.getHumedadRelativa() != null ? record.getHumedadRelativa() : "", style);
			createCell(row, columnCount++, record.getTopografia() != null ? record.getTopografia() : "", style);
			createCell(row, columnCount++, record.getTenenciaPredio() != null ? record.getTenenciaPredio() : "", style);
			createCell(row, columnCount++, record.getDistanciaPredioCabeceraMunicipal() != null ? record.getDistanciaPredioCabeceraMunicipal() : "", style);
			createCell(row, columnCount++, record.getMapaFinca() != null ? Boolean.TRUE.equals(record.getMapaFinca()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getEstadoViaAcceso() != null ? record.getEstadoViaAcceso() : "", style);
			createCell(row, columnCount++, record.getTieneComputador() != null ? Boolean.TRUE.equals(record.getTieneComputador()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getTieneInternet() != null ? Boolean.TRUE.equals(record.getTieneInternet()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getUsaSoftware() != null ? Boolean.TRUE.equals(record.getUsaSoftware()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getNombreSoftware() != null ? record.getNombreSoftware() : "", style);
			createCell(row, columnCount++, record.getInformacionTecnicaPrimaria() != null ? record.getInformacionTecnicaPrimaria() : "", style);
			createCell(row, columnCount++, record.getResponsableInformacionEmpresa() != null ? record.getResponsableInformacionEmpresa() : "", style);
			createCell(row, columnCount++, record.getFincaCertificada() != null ? Boolean.TRUE.equals(record.getFincaCertificada()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getFincaProcesoCertificacion() != null ? Boolean.TRUE.equals(record.getFincaProcesoCertificacion()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getParametrosTecnicos() != null ? Boolean.TRUE.equals(record.getParametrosTecnicos()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getCostoProduccionAnimales() != null ? Boolean.TRUE.equals(record.getCostoProduccionAnimales()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getTipoProduccion() != null ? record.getTipoProduccion() : "", style);
			createCell(row, columnCount++, record.getPesoNacimiento() != null ? record.getPesoNacimiento() : "", style);
			createCell(row, columnCount++, record.getPesoDestete() != null ? record.getPesoDestete() : "", style);
			createCell(row, columnCount++, record.getPesoPrimerServicio() != null ? record.getPesoPrimerServicio() : "", style);
			createCell(row, columnCount++, record.getParto() != null ? record.getParto() : "", style);
			createCell(row, columnCount++, record.getInicioCeba() != null ? record.getInicioCeba() : "", style);
			createCell(row, columnCount++, record.getFinalCeba() != null ? record.getFinalCeba() : "", style);
			createCell(row, columnCount++, record.getAsistenciaTecnica() != null ? Boolean.TRUE.equals(record.getAsistenciaTecnica()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getTipoEntidad() != null ? record.getTipoEntidad() : "", style);
			createCell(row, columnCount++, record.getParticipaProyectoAnteriorGobernacion() != null ? Boolean.TRUE.equals(record.getParticipaProyectoAnteriorGobernacion()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getAnioParticipaGobernacion() != null ? record.getAnioParticipaGobernacion() : "", style);
			createCell(row, columnCount++, record.getParticipaProyectoAnteriorMinisterioAgricultura() != null ? Boolean.TRUE.equals(record.getParticipaProyectoAnteriorMinisterioAgricultura()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getAnioParticipaMinisterioAgricultura() != null ? record.getAnioParticipaMinisterioAgricultura() : "", style);
			createCell(row, columnCount++, record.getNombreEntidad() != null ? record.getNombreEntidad() : "", style);
			createCell(row, columnCount++, record.getMejoramientoGenetico() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getPatosForrajes() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getAlimentacionAnimal() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getBuenasPracticasGanaderas() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getOtro() != null ? record.getOtro() : "", style);
			createCell(row, columnCount++, record.getSanidadAnimal() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getGestionAdministrativa() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getBuenasPracticasOrdeno() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getBiotecnologiaReproduccion() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getTipoPastoPredio() != null ? record.getTipoPastoPredio() : "", style);
			createCell(row, columnCount++, record.getSuplementa() != null ? Boolean.TRUE.equals(record.getSuplementa()) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getDescripcionSuplementa() != null ? record.getDescripcionSuplementa() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableUno() != null ? record.getTecnicoResponsableUno() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalUno() != null ? record.getTarjetaProfesionalUno() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableDos() != null ? record.getTecnicoResponsableDos() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalDos() != null ? record.getTarjetaProfesionalDos() : "", style);
		}
	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
}

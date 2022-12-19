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

import co.com.ccarn.model.ConceptoListaChequeo;
import co.com.ccarn.model.ListaChequeo;

public class ExcelGeneratorBpg {

	private List<ListaChequeo> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelGeneratorBpg(List<ListaChequeo> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Lista Chequeo BPG");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "# Registro", style);
		createCell(row, 1, "Fecha de Auditoría", style);
		createCell(row, 2, "Número de RSPP- ISPP", style);
		createCell(row, 3, "Departamento", style);
		createCell(row, 4, "Municipio", style);
		createCell(row, 5, "Nombre del Predio", style);
		createCell(row, 6, "Latitud", style);
		createCell(row, 7, "Longitud", style);
		createCell(row, 8, "Especie", style);
		createCell(row, 9, "Cria", style);
		createCell(row, 10, "Levante", style);
		createCell(row, 11, "Ceba", style);
		createCell(row, 12, "Ciclo Completo", style);
		createCell(row, 13, "Vereda", style);
		createCell(row, 14, "Total Animales", style);
		createCell(row, 15, "Propietario", style);
		createCell(row, 16, "Teléfono", style);
		createCell(row, 17, "Número de Identificación", style);
		createCell(row, 18, "Correo Electrónico", style);
		createCell(row, 19, "Responsable del Manejo Saniario", style);
		createCell(row, 20, "MV", style);
		createCell(row, 21, "MVZ", style);
		createCell(row, 22, "Matrícula Profesional", style);
		createCell(row, 23, "Correo Electrónico Responsable", style);
		createCell(row, 24, "Teléfono Responsable", style);
		createCell(row, 25, "Tipo de Visita", style);
		createCell(row, 26, "Cantidad de Criterios Fundamentales que NO APLICA", style);
		createCell(row, 27, "Cantidad de Criterios Mayores que NO APLICA", style);
		createCell(row, 28, "Cantidad de Criterios Menores que NO APLICA", style);
		createCell(row, 29, "Cantidad de Criterios Fundamentales que NO CUMPLE", style);
		createCell(row, 30, "Cantidad de Criterios Mayores que NO CUMPLE", style);
		createCell(row, 31, "Cantidad de Criterios Menores que NO CUMPLE", style);
		createCell(row, 32, "Cantidad de Criterios Fundamentales que CUMPLE", style);
		createCell(row, 33, "Cantidad de Criterios Mayores que CUMPLE", style);
		createCell(row, 34, "Cantidad de Criterios Menores que CUMPLE", style);
		createCell(row, 35, "Porcentaje de Cumplimiento Criterios Fundamentales", style);
		createCell(row, 36, "Porcentaje de Cumplimiento Criterios Mayores", style);
		createCell(row, 37, "Porcentaje de Cumplimiento Criterios Menores", style);
		createCell(row, 38, "Concepto", style);
		createCell(row, 39, "Observaciones", style);
		createCell(row, 40, "Nombre Completo Persona que Atendió la Visita", style);
		createCell(row, 41, "Cédula Persona que Atendió la Visita", style);
		createCell(row, 42, "Nombre Completo Auditor", style);
		createCell(row, 43, "Matrícula Profesional Auditor", style);
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
		} else if (valueOfCell instanceof Double) {
			cell.setCellValue((Double) valueOfCell);
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
		for (ListaChequeo record : lista) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style);
			createCell(row, columnCount++, record.getFechaAuditoria() != null ? dateFormatter.format(record.getFechaAuditoria()) : ""  , style);
			createCell(row, columnCount++, record.getNumeroRsppIspp() != null ? record.getNumeroRsppIspp() : "", style);
			createCell(row, columnCount++, record.getDepartamento() != null ? record.getDepartamento() : "", style);
			createCell(row, columnCount++, record.getMunicipio() != null ? record.getMunicipio() : "", style);
			createCell(row, columnCount++, record.getNombrePredio() != null ? record.getNombrePredio() : "", style);
			createCell(row, columnCount++, record.getLatitud() != null ? record.getLatitud().toString() : "", style);
			createCell(row, columnCount++, record.getLongitud() != null ? record.getLongitud().toString() : "", style);
			createCell(row, columnCount++, record.getEspecie() != null ? record.getEspecie() : "", style);
			createCell(row, columnCount++, record.getCria() != null ? "SI" : "NO", style);
			createCell(row, columnCount++, record.getLevante() != null ? "SI" : "NO", style);
			createCell(row, columnCount++, record.getCeba() != null ? "SI" : "NO", style);
			createCell(row, columnCount++, record.getCicloCompleto() != null ? "SI" : "NO", style);
			createCell(row, columnCount++, record.getVereda() != null ? record.getVereda() : "", style);
			createCell(row, columnCount++, record.getTotalAnimales() != null ? record.getTotalAnimales() : "", style);
			createCell(row, columnCount++, record.getNombrePropietario() != null ? record.getNombrePropietario() : "", style);
			createCell(row, columnCount++, record.getTelefonoPropietario() != null ? record.getTelefonoPropietario() : "", style);
			createCell(row, columnCount++, record.getNumeroIdentificacion() != null ? record.getNumeroIdentificacion() : "", style);
			createCell(row, columnCount++, record.getCorreoElectronicoPropietario() != null ? record.getCorreoElectronicoPropietario() : "", style);
			createCell(row, columnCount++, record.getResponsableManejoSanitario() != null ? record.getResponsableManejoSanitario() : "", style);
			createCell(row, columnCount++, record.getMv() != null ? record.getMv().equals(1) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getMvz() != null ? record.getMvz().equals(1) ? "SI" : "NO" : "", style);
			createCell(row, columnCount++, record.getNumeroMatricula() != null ? record.getNumeroMatricula() : "", style);
			createCell(row, columnCount++, record.getCorreoElectronicoResponsable() != null ? record.getCorreoElectronicoResponsable() : "", style);
			createCell(row, columnCount++, record.getTelefonoResponsable() != null ? record.getTelefonoResponsable() : "", style);
			createCell(row, columnCount++, record.getTipoVisita() != null ? record.getTipoVisita() : "", style);
			
			for(ConceptoListaChequeo chequeo : record.getConceptoListaChequeos()) {
				createCell(row, columnCount++, chequeo.getCriterioNoAplicaFundamental() != null ? chequeo.getCriterioNoAplicaFundamental() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioNoAplicaMayor() != null ? chequeo.getCriterioNoAplicaMayor() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioNoAplicaMenor() != null ? chequeo.getCriterioNoAplicaMenor() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioNoCumpleFundamental() != null ? chequeo.getCriterioNoCumpleFundamental() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioNoCumpleMayor() != null ? chequeo.getCriterioNoCumpleMayor() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioNoCumpleMenor() != null ? chequeo.getCriterioNoCumpleMenor() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioSiCumpleFundamental() != null ? chequeo.getCriterioSiCumpleFundamental() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioSiCumpleMayor() != null ? chequeo.getCriterioSiCumpleMayor() : "", style);
				createCell(row, columnCount++, chequeo.getCriterioSiCumpleMenor() != null ? chequeo.getCriterioSiCumpleMenor() : "", style);
				createCell(row, columnCount++, chequeo.getPorcentajeCumplimientoFundamental() != null ? chequeo.getPorcentajeCumplimientoFundamental()*100 : "", style);
				createCell(row, columnCount++, chequeo.getPorcentajeCumplimientoMayor() != null ? chequeo.getPorcentajeCumplimientoMayor()*100 : "", style);
				createCell(row, columnCount++, chequeo.getPorcentajeCumplimientoMenor() != null ? chequeo.getPorcentajeCumplimientoMenor()*100 : "", style);
				createCell(row, columnCount++, chequeo.getConcepto() != null ? chequeo.getConcepto() : "", style);
				createCell(row, columnCount++, chequeo.getObservaciones() != null ? chequeo.getObservaciones() : "", style);
				createCell(row, columnCount++, chequeo.getNombreAtiende() != null ? chequeo.getNombreAtiende() : "", style);
				createCell(row, columnCount++, chequeo.getNumeroIdentificacionAtiende() != null ? chequeo.getNumeroIdentificacionAtiende() : "", style);
				createCell(row, columnCount++, chequeo.getNombreAuditoria() != null ? chequeo.getNombreAuditoria() : "", style);
				createCell(row, columnCount++, chequeo.getNumeroIdentificacionAuditoria() != null ? chequeo.getNumeroIdentificacionAuditoria() : "", style);
			}
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

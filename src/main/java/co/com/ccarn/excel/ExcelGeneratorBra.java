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

import co.com.ccarn.model.DetalleFormato;
import co.com.ccarn.model.Formato;

public class ExcelGeneratorBra {
	
	private List<Formato> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorBra(List<Formato> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Registro BRA");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "# Registro", style);
		createCell(row, 1, "Fecha", style);
		createCell(row, 2, "Departamento", style);
		createCell(row, 3, "Municipio", style);
		createCell(row, 4, "Nombre Propietario", style);
		createCell(row, 5, "Vereda", style);
		createCell(row, 6, "Profesional a Cargo #1", style);
		createCell(row, 7, "Profesional a Cargo #2", style);
		createCell(row, 8, "Consideraciones Finales", style);
		createCell(row, 9, "Técnico Responsable #1", style);
		createCell(row, 10, "Tarjeta Profesional #1", style);
		createCell(row, 11, "Técnico Responsable #2", style);
		createCell(row, 12, "Tarjeta Profesional #2", style);
		createCell(row, 13, "Número Identificación", style);
		createCell(row, 14, "Nombre", style);
		createCell(row, 15, "Color", style);
		createCell(row, 16, "Edad en Meses", style);
		createCell(row, 17, "Número de Partos", style);
		createCell(row, 18, "Estado Reproductivo", style);
		createCell(row, 19, "Diagnóstico", style);
		createCell(row, 20, "Anormalidades", style);
		createCell(row, 21, "Condición Corporal", style);
		createCell(row, 22, "Seleccionada", style);
		createCell(row, 23, "IATF", style);
		createCell(row, 24, "TE", style);
		createCell(row, 25, "Observaciones", style);
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
		int columnCountAux = 0;
		for (Formato record : lista) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style);
			createCell(row, columnCount++, record.getFecha() != null ? dateFormatter.format(record.getFecha()) : ""  , style);
			createCell(row, columnCount++, record.getDepartamento() != null ? record.getDepartamento() : "", style);
			createCell(row, columnCount++, record.getMunicipio() != null ? record.getMunicipio() : "", style);
			createCell(row, columnCount++, record.getNombrePropietario() != null ? record.getNombrePropietario() : "", style);
			createCell(row, columnCount++, record.getVereda() != null ? record.getVereda() : "", style);
			createCell(row, columnCount++, record.getProfesionalACargoUno() != null ? record.getProfesionalACargoUno() : "", style);
			createCell(row, columnCount++, record.getProfesionalACargoDos() != null ? record.getProfesionalACargoDos() : "", style);
			createCell(row, columnCount++, record.getRecomendacion() != null ? record.getRecomendacion() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableUno() != null ? record.getTecnicoResponsableUno() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalUno() != null ? record.getTarjetaProfesionalUno() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableDos() != null ? record.getTecnicoResponsableDos() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalDos() != null ? record.getTarjetaProfesionalDos() : "", style);
			columnCountAux=columnCount;
			for(DetalleFormato detalleFormato : record.getDetalleFormatos()) {
				createCell(row, columnCount, detalleFormato.getNumeroIdentificacion() != null ? detalleFormato.getNumeroIdentificacion() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getNombreIdentificacion() != null ? detalleFormato.getNombreIdentificacion() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getColor() != null ? detalleFormato.getColor() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getEdadMeses() != null ? detalleFormato.getEdadMeses() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getNumeroPartos() != null ? detalleFormato.getNumeroPartos() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getEr() != null ? detalleFormato.getEr() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getDx() != null ? detalleFormato.getDx() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getAn() != null ? detalleFormato.getAn() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getCp() != null ? detalleFormato.getCp() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getSeleccionada() != null ? detalleFormato.getSeleccionada().equals(1) ? "SI" : "NO" : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getIatf() != null ? detalleFormato.getIatf() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getTe() != null ? detalleFormato.getTe() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getObservacion() != null ? detalleFormato.getObservacion() : "", style);
				columnCount=columnCountAux;
				row = sheet.createRow(rowCount++);
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

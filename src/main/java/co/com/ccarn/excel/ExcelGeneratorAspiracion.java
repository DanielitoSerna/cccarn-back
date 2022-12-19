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

public class ExcelGeneratorAspiracion {
	
	private List<Formato> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorAspiracion(List<Formato> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Registro Aspiracion Folicular");
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
		createCell(row, 5, "Nombre Finca", style);
		createCell(row, 6, "Vereda", style);
		createCell(row, 7, "Profesional a Cargo #1", style);
		createCell(row, 8, "Profesional a Cargo #2", style);
		createCell(row, 9, "Número Receptoras Seleccionadas", style);
		createCell(row, 10, "Número Receptoras Transferidas", style);
		createCell(row, 11, "Observaciones", style);
		createCell(row, 12, "Técnico Responsable #1", style);
		createCell(row, 13, "Tarjeta Profesional #1", style);
		createCell(row, 14, "Técnico Responsable #2", style);
		createCell(row, 15, "Tarjeta Profesional #2", style);
		createCell(row, 16, "Fecha", style);
		createCell(row, 17, "Donadora", style);
		createCell(row, 18, "Raza", style);
		createCell(row, 19, "Programación", style);
		createCell(row, 20, "Toro", style);
		createCell(row, 21, "Raza", style);
		createCell(row, 22, "G1", style);
		createCell(row, 23, "G2", style);
		createCell(row, 24, "G3", style);
		createCell(row, 25, "DEG", style);
		createCell(row, 26, "MV", style);
		createCell(row, 27, "Total", style);
		createCell(row, 28, "Seleccionada", style);
		createCell(row, 29, "Observaciones", style);
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
			createCell(row, columnCount++, record.getNombreFinca() != null ? record.getNombreFinca() : "", style);
			createCell(row, columnCount++, record.getVereda() != null ? record.getVereda() : "", style);
			createCell(row, columnCount++, record.getProfesionalACargoUno() != null ? record.getProfesionalACargoUno() : "", style);
			createCell(row, columnCount++, record.getProfesionalACargoDos() != null ? record.getProfesionalACargoDos() : "", style);
			createCell(row, columnCount++, record.getNumeroReceptorasSeleccionadas() != null ? record.getNumeroReceptorasSeleccionadas() : "", style);
			createCell(row, columnCount++, record.getNumeroReceptorasTransfericas() != null ? record.getNumeroReceptorasTransfericas() : "", style);
			createCell(row, columnCount++, record.getRecomendacion() != null ? record.getRecomendacion() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableUno() != null ? record.getTecnicoResponsableUno() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalUno() != null ? record.getTarjetaProfesionalUno() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableDos() != null ? record.getTecnicoResponsableDos() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalDos() != null ? record.getTarjetaProfesionalDos() : "", style);
			columnCountAux=columnCount;
			for(DetalleFormato detalleFormato : record.getDetalleFormatos()) {
				createCell(row, columnCount, detalleFormato.getFecha() != null ? dateFormatter.format(detalleFormato.getFecha()) : ""  , style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getNombreDonadora() != null ? detalleFormato.getNombreDonadora() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getRazaDonadora() != null ? detalleFormato.getRazaDonadora() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getProgramacion() != null ? detalleFormato.getProgramacion() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getNombreToro() != null ? detalleFormato.getNombreToro() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getRazaToro() != null ? detalleFormato.getRazaToro() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getG1() != null ? detalleFormato.getG1() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getG2() != null ? detalleFormato.getG2() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getG3() != null ? detalleFormato.getG3() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getDeg() != null ? detalleFormato.getDeg() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getMiv() != null ? detalleFormato.getMiv() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getTotal() != null ? detalleFormato.getTotal() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getSeleccionada() != null ? detalleFormato.getSeleccionada().equals(1) ? "SI" : "NO" : "", style);
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

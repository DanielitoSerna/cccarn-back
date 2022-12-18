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
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
//		createCell(row, 3, "Nombre del Propietario", style);
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

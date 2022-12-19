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

import co.com.ccarn.model.EncabezadoRegistro;
import co.com.ccarn.model.Registro;

public class ExcelGeneratorTratamiento {
	
	private List<EncabezadoRegistro> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorTratamiento(List<EncabezadoRegistro> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Tratamientos Veterinarios");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "# Registro", style);
		createCell(row, 1, "Empresa Ganadera", style);
		createCell(row, 2, "Municipio", style);
		createCell(row, 3, "ID Animal", style);
		createCell(row, 4, "Fecha Inicio Tratamiento", style);
		createCell(row, 5, "Nombre del Medicamento", style);
		createCell(row, 6, "Uso", style);
		createCell(row, 7, "Laboratorio", style);
		createCell(row, 8, "Número de Lote", style);
		createCell(row, 9, "Número Registro de ICA", style);
		createCell(row, 10, "Dosis", style);
		createCell(row, 11, "Vía de Aplicación", style);
		createCell(row, 12, "Duración Tratamiento", style);
		createCell(row, 13, "Tiempo de Retiro", style);
		createCell(row, 14, "Responsable", style);
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
		int columnCountAux = 0;
		for (EncabezadoRegistro record : lista) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style);
			createCell(row, columnCount++, record.getEmpresaGanadera() != null ? record.getEmpresaGanadera() : "", style);
			createCell(row, columnCount++, record.getMunicipio() != null ? record.getMunicipio() : "", style);
			columnCountAux=columnCount;
			for(Registro registro : record.getRegistros()) {
				createCell(row, columnCount, registro.getIdAnimal() != null ? registro.getIdAnimal() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getFechaInicioTratamiento() != null ? dateFormatter.format(registro.getFechaInicioTratamiento()) : ""  , style);
				columnCount++;
				createCell(row, columnCount, registro.getNombreMedicamento() != null ? registro.getNombreMedicamento() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getUso() != null ? registro.getUso() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getLaboratorio() != null ? registro.getLaboratorio() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getLote() != null ? registro.getLote() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getRegistroIca() != null ? registro.getRegistroIca() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getDosis() != null ? registro.getDosis() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getViaAplicacion() != null ? registro.getViaAplicacion() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getDuracionTratamiento() != null ? registro.getDuracionTratamiento() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getTiempoRetiro() != null ? registro.getTiempoRetiro() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getResponsable() != null ? registro.getResponsable() : "", style);
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

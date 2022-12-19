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

public class ExcelGeneratorPersona {
	
	private List<EncabezadoRegistro> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorPersona(List<EncabezadoRegistro> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Control Personas Vehículos");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "# Registro", style);
		createCell(row, 1, "Empresa Ganadera", style);
		createCell(row, 2, "Municipio", style);
		createCell(row, 3, "Fecha", style);
		createCell(row, 4, "Nombre", style);
		createCell(row, 5, "Identificación", style);
		createCell(row, 6, "Teléfono", style);
		createCell(row, 7, "Placa", style);
		createCell(row, 8, "Procedencia", style);
		createCell(row, 9, "Motivo de la Visita", style);
		
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
				createCell(row, columnCount, registro.getFechaIngresoPersona() != null ? dateFormatter.format(registro.getFechaIngresoPersona()) : ""  , style);
				columnCount++;
				createCell(row, columnCount, registro.getNombreIngresoPersona() != null ? registro.getNombreIngresoPersona() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getIdentificacionIngresoPersona() != null ? registro.getIdentificacionIngresoPersona() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getTelefonoIngresoPersona() != null ? registro.getTelefonoIngresoPersona() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getProducto() != null ? registro.getProducto() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getProcedenciaIngresoPersona() != null ? registro.getProcedenciaIngresoPersona() : "", style);
				columnCount++;
				createCell(row, columnCount, registro.getMotivoVisita() != null ? registro.getMotivoVisita() : "", style);
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

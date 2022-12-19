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

public class ExcelGeneratorHembra {
	
	private List<Formato> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorHembra(List<Formato> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Registro Hembras");
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
		createCell(row, 4, "Empaque de Embriones", style);
		createCell(row, 5, "Nombre Propietario", style);
		createCell(row, 6, "Transferidor", style);
		createCell(row, 7, "Nombre Finca", style);
		createCell(row, 8, "Vereda", style);
		createCell(row, 9, "Profesional Producción Invitro de Embriones", style);
		createCell(row, 10, "Profesional a Cargo #1", style);
		createCell(row, 11, "Profesional a Cargo #2", style);
		createCell(row, 12, "Técnico Responsable #1", style);
		createCell(row, 13, "Tarjeta Profesional #1", style);
		createCell(row, 14, "Técnico Responsable #2", style);
		createCell(row, 15, "Tarjeta Profesional #2", style);
		createCell(row, 16, "Donadora", style);
		createCell(row, 17, "Raza", style);
		createCell(row, 18, "Toro", style);
		createCell(row, 19, "Raza", style);
		createCell(row, 20, "Embrión", style);
		createCell(row, 21, "Receptora", style);
		createCell(row, 22, "Ovario", style);
		createCell(row, 23, "Preñez", style);
		createCell(row, 24, "Hallazgos", style);
		createCell(row, 25, "Sx", style);
		createCell(row, 26, "Observaciones", style);
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
			createCell(row, columnCount++, record.getEmpaqueEmbriones() != null ? record.getEmpaqueEmbriones() : "", style);
			createCell(row, columnCount++, record.getNombrePropietario() != null ? record.getNombrePropietario() : "", style);
			createCell(row, columnCount++, record.getTransferidor() != null ? record.getTransferidor() : "", style);
			createCell(row, columnCount++, record.getNombreFinca() != null ? record.getNombreFinca() : "", style);
			createCell(row, columnCount++, record.getVereda() != null ? record.getVereda() : "", style);
			createCell(row, columnCount++, record.getProfesionalProduccionInvitroEmbriones() != null ? record.getProfesionalProduccionInvitroEmbriones() : "", style);
			createCell(row, columnCount++, record.getProfesionalACargoUno() != null ? record.getProfesionalACargoUno() : "", style);
			createCell(row, columnCount++, record.getProfesionalACargoDos() != null ? record.getProfesionalACargoDos() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableUno() != null ? record.getTecnicoResponsableUno() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalUno() != null ? record.getTarjetaProfesionalUno() : "", style);
			createCell(row, columnCount++, record.getTecnicoResponsableDos() != null ? record.getTecnicoResponsableDos() : "", style);
			createCell(row, columnCount++, record.getTarjetaProfesionalDos() != null ? record.getTarjetaProfesionalDos() : "", style);
			columnCountAux=columnCount;
			for(DetalleFormato detalleFormato : record.getDetalleFormatos()) {
				createCell(row, columnCount, detalleFormato.getNombreDonadora() != null ? detalleFormato.getNombreDonadora() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getRazaDonadora() != null ? detalleFormato.getRazaDonadora() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getNombreToro() != null ? detalleFormato.getNombreToro() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getRazaToro() != null ? detalleFormato.getRazaToro() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getEmbrion() != null ? detalleFormato.getEmbrion() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getReceptora() != null ? detalleFormato.getReceptora() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getOvario() != null ? detalleFormato.getOvario() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getP60() != null ? detalleFormato.getP60() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getHallazgo() != null ? detalleFormato.getHallazgo() : "", style);
				columnCount++;
				createCell(row, columnCount, detalleFormato.getSx() != null ? detalleFormato.getSx() : "", style);
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

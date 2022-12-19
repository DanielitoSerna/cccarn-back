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

import co.com.ccarn.model.Formato;

public class ExcelGeneratorAndrologica {
	
	private List<Formato> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorAndrologica(List<Formato> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Registro IATF");
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
		createCell(row, 9, "Identificación Animal", style);
		createCell(row, 10, "Raza", style);
		createCell(row, 11, "Fecha Nacimiento", style);
		createCell(row, 12, "Condición Corporal", style);
		createCell(row, 13, "Patas y Pezuñas", style);
		createCell(row, 14, "Testículos", style);
		createCell(row, 15, "Pene", style);
		createCell(row, 16, "Prepucio", style);
		createCell(row, 17, "Circunferencia Escrotal", style);
		createCell(row, 18, "Volumen Fresco (ML)", style);
		createCell(row, 19, "Volumen Post-Congelación (ML)", style);
		createCell(row, 20, "Color Fresco", style);
		createCell(row, 21, "Color Post-Congelación", style);
		createCell(row, 22, "Olor Fresco", style);
		createCell(row, 23, "Olor Post-Congelación", style);
		createCell(row, 24, "Ph Fresco", style);
		createCell(row, 25, "Ph Post-Congelación", style);
		createCell(row, 26, "Concentración Fresco", style);
		createCell(row, 27, "Concentración Post-Congelación", style);
		createCell(row, 28, "Movilidad Masal Fresco", style);
		createCell(row, 29, "Movilidad Masal Post-Congelación", style);
		createCell(row, 30, "Movilidad Total Fresco", style);
		createCell(row, 31, "Movilidad Total Post-Congelación", style);
		createCell(row, 32, "Movilidad Progresiva Fresco", style);
		createCell(row, 33, "Movilidad Progresiva Post-Congelación", style);
		createCell(row, 34, "Integridad de Membrana Fresco", style);
		createCell(row, 35, "Integridad de Membrana Post-Congelación", style);
		createCell(row, 36, "Lívido", style);
		createCell(row, 37, "Capacidad para Montar", style);
		createCell(row, 38, "Observaciones", style);
		createCell(row, 39, "Vesículas Seminales", style);
		createCell(row, 40, "Próstata", style);
		createCell(row, 41, "Electroeyaculador", style);
		createCell(row, 42, "Vagina artificial", style);
		createCell(row, 43, "Protusión", style);
		createCell(row, 44, "Eyaculación", style);
		createCell(row, 45, "Técnico Responsable #1", style);
		createCell(row, 46, "Tarjeta Profesional #1", style);
		createCell(row, 47, "Técnico Responsable #2", style);
		createCell(row, 48, "Tarjeta Profesional #2", style);
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
			createCell(row, columnCount++, record.getDetalleAndrologico().getInformacionAnimal() != null ? record.getDetalleAndrologico().getInformacionAnimal() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getRaza() != null ? record.getDetalleAndrologico().getRaza() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getFechaNacimiento() != null ? dateFormatter.format(record.getDetalleAndrologico().getFechaNacimiento()) : ""  , style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getCondicionCorporal() != null ? record.getDetalleAndrologico().getCondicionCorporal() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getPatasPezunas() != null ? record.getDetalleAndrologico().getPatasPezunas() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getTesticulos() != null ? record.getDetalleAndrologico().getTesticulos() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getPene() != null ? record.getDetalleAndrologico().getPene() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getPrepucio() != null ? record.getDetalleAndrologico().getPrepucio() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getCircunferenciaEscrotal() != null ? record.getDetalleAndrologico().getCircunferenciaEscrotal() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getVolumenFresco() != null ? record.getDetalleAndrologico().getVolumenFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getVolumenPostDescongelacion() != null ? record.getDetalleAndrologico().getVolumenPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getColorFresco() != null ? record.getDetalleAndrologico().getColorFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getColorPostDescongelacion() != null ? record.getDetalleAndrologico().getColorPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getOlorFresco() != null ? record.getDetalleAndrologico().getOlorFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getOlorPostDescongelacion() != null ? record.getDetalleAndrologico().getOlorPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getPhFresco() != null ? record.getDetalleAndrologico().getPhFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getPhPostDescongelacion() != null ? record.getDetalleAndrologico().getPhPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getConcentracionFresco() != null ? record.getDetalleAndrologico().getConcentracionFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getConcentracionPostDescongelacion() != null ? record.getDetalleAndrologico().getConcentracionPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getMovilidadMasalFresco() != null ? record.getDetalleAndrologico().getMovilidadMasalFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getMovilidadMasalPostDescongelacion() != null ? record.getDetalleAndrologico().getMovilidadMasalPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getMovilidadTotalFresco() != null ? record.getDetalleAndrologico().getMovilidadTotalFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getMovilidadTotalPostDescongelacion() != null ? record.getDetalleAndrologico().getMovilidadTotalPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getMovilidadProgresivaFresco() != null ? record.getDetalleAndrologico().getMovilidadProgresivaFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getMovilidadProgresivaPostDescongelacion() != null ? record.getDetalleAndrologico().getMovilidadProgresivaPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getIntegridadMembranaFresco() != null ? record.getDetalleAndrologico().getIntegridadMembranaFresco() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getIntegridadMembranaPostDescongelacion() != null ? record.getDetalleAndrologico().getIntegridadMembranaPostDescongelacion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getLivido() != null ? record.getDetalleAndrologico().getLivido() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getCapacidadParaMontar() != null ? record.getDetalleAndrologico().getCapacidadParaMontar() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getObservaciones() != null ? record.getDetalleAndrologico().getObservaciones() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getVesiculasSeminales() != null ? record.getDetalleAndrologico().getVesiculasSeminales() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getProstata() != null ? record.getDetalleAndrologico().getProstata() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getElectroeyaculador() != null ? record.getDetalleAndrologico().getElectroeyaculador() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getVaginaArtificial() != null ? record.getDetalleAndrologico().getVaginaArtificial() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getProtusion() != null ? record.getDetalleAndrologico().getProtusion() : "", style);
			createCell(row, columnCount++, record.getDetalleAndrologico().getEyaculacion() != null ? record.getDetalleAndrologico().getEyaculacion() : "", style);
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

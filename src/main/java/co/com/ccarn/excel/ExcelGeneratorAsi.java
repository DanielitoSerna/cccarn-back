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

public class ExcelGeneratorAsi {
	
	private List<ListaChequeo> lista;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelGeneratorAsi(List<ListaChequeo> lista) {
		this.lista = lista;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeader() {
		sheet = workbook.createSheet("Lista Chequeo ASI");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "# Registro", style);
		createCell(row, 1, "Fecha", style);
		createCell(row, 2, "Objeto", style);
		createCell(row, 3, "Número de Regustro del Predio", style);
		createCell(row, 4, "Nombre del Predio", style);
		createCell(row, 5, "Departamento", style);
		createCell(row, 6, "Municipio", style);
		createCell(row, 7, "Vereda", style);
		createCell(row, 8, "Nombre Propietario", style);
		createCell(row, 9, "Número Identificación", style);
		createCell(row, 10, "Área Total del Predio en Hectáreas", style);
		createCell(row, 11, "Correo Electrónico del Propietario", style);
		createCell(row, 12, "Teléfono Propietario", style);
		createCell(row, 13, "Cantidad Bovinos", style);
		createCell(row, 14, "Cantidad Bufalinos", style);
		createCell(row, 15, "Cantidad Équidos", style);
		createCell(row, 16, "Cantidad Porcinos", style);
		createCell(row, 17, "Cantidad Ovinos", style);
		createCell(row, 18, "Cantidad Caprinos", style);
		createCell(row, 19, "Cantidad Aves de Corral", style);
		createCell(row, 20, "Cantidad Conejos", style);
		createCell(row, 21, "Cantidad Peces de Cultivo", style);
		createCell(row, 22, "Cantidad Zoocría", style);
		createCell(row, 23, "Cría", style);
		createCell(row, 24, "Levante", style);
		createCell(row, 25, "Ceba (Engorde)", style);
		createCell(row, 26, "Leche", style);
		createCell(row, 27, "Postura", style);
		createCell(row, 28, "Material Genético", style);
		createCell(row, 29, "Otro", style);
		createCell(row, 30, "Cantidad de Criterios Fundamentales que NO APLICA", style);
		createCell(row, 31, "Cantidad de Criterios Mayores que NO APLICA", style);
		createCell(row, 32, "Cantidad de Criterios Menores que NO APLICA", style);
		createCell(row, 33, "Cantidad de Criterios Fundamentales que NO CUMPLE", style);
		createCell(row, 34, "Cantidad de Criterios Mayores que NO CUMPLE", style);
		createCell(row, 35, "Cantidad de Criterios Menores que NO CUMPLE", style);
		createCell(row, 36, "Cantidad de Criterios Fundamentales que CUMPLE", style);
		createCell(row, 37, "Cantidad de Criterios Mayores que CUMPLE", style);
		createCell(row, 38, "Cantidad de Criterios Menores que CUMPLE", style);
		createCell(row, 39, "Porcentaje de Cumplimiento Criterios Fundamentales", style);
		createCell(row, 40, "Porcentaje de Cumplimiento Criterios Mayores", style);
		createCell(row, 41, "Porcentaje de Cumplimiento Criterios Menores", style);
		createCell(row, 42, "Concepto", style);
		createCell(row, 43, "Observaciones", style);
		createCell(row, 44, "Nombre Completo", style);
		createCell(row, 45, "Cédula", style);
		createCell(row, 46, "Nombre Completo", style);
		createCell(row, 47, "Cédula", style);
		createCell(row, 48, "Nombre Completo", style);
		createCell(row, 49, "Cédula", style);
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
			createCell(row, columnCount++, record.getFecha() != null ? dateFormatter.format(record.getFecha()) : ""  , style);
			createCell(row, columnCount++, record.getObjeto() != null ? record.getObjeto() : "", style);
			createCell(row, columnCount++, record.getNumeroRegistroPredio() != null ? record.getNumeroRegistroPredio() : "", style);
			createCell(row, columnCount++, record.getNombrePredio() != null ? record.getNombrePredio() : "", style);
			createCell(row, columnCount++, record.getDepartamento() != null ? record.getDepartamento() : "", style);
			createCell(row, columnCount++, record.getMunicipio() != null ? record.getMunicipio() : "", style);
			createCell(row, columnCount++, record.getVereda() != null ? record.getVereda() : "", style);
			createCell(row, columnCount++, record.getNombrePropietario() != null ? record.getNombrePropietario() : "", style);
			createCell(row, columnCount++, record.getNumeroIdentificacion() != null ? record.getNumeroIdentificacion() : "", style);
			createCell(row, columnCount++, record.getAreaTotalPredio() != null ? record.getAreaTotalPredio() : "", style);
			createCell(row, columnCount++, record.getCorreoElectronicoPropietario() != null ? record.getCorreoElectronicoPropietario() : "", style);
			createCell(row, columnCount++, record.getTelefonoPropietario() != null ? record.getTelefonoPropietario() : "", style);
			createCell(row, columnCount++, record.getBovinos() != null ? record.getBovinos() : "", style);
			createCell(row, columnCount++, record.getBufalinos() != null ? record.getBufalinos() : "", style);
			createCell(row, columnCount++, record.getEquidos() != null ? record.getEquidos() : "", style);
			createCell(row, columnCount++, record.getPorcinos() != null ? record.getPorcinos() : "", style);
			createCell(row, columnCount++, record.getOvinos() != null ? record.getOvinos() : "", style);
			createCell(row, columnCount++, record.getCaprinos() != null ? record.getCaprinos() : "", style);
			createCell(row, columnCount++, record.getAvesCorral() != null ? record.getAvesCorral() : "", style);
			createCell(row, columnCount++, record.getConejos() != null ? record.getConejos() : "", style);
			createCell(row, columnCount++, record.getPecesCultivo() != null ? record.getPecesCultivo() : "", style);
			createCell(row, columnCount++, record.getZoocria() != null ? record.getZoocria() : "", style);
			createCell(row, columnCount++, record.getCria() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getLevante() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getCeba() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getLeche() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getPostura() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getMaterialGenetico() != null ? "SI" : "", style);
			createCell(row, columnCount++, record.getOtro() != null ? record.getOtro() : "", style);
			
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
				createCell(row, columnCount++, chequeo.getNombreAtiendeDos() != null ? chequeo.getNombreAtiendeDos() : "", style);
				createCell(row, columnCount++, chequeo.getNumeroIdentificacionAtiendeDos() != null ? chequeo.getNumeroIdentificacionAtiendeDos() : "", style);
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

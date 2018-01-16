package com.tcs.Repo.Export;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.tcs.Repo.model.ProjectionVO;

public class ExcelView extends AbstractXlsView {

	private static final String[] titles = { "Project", "Tower", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
			"SEP", "OCT", "NOV", "DEC" };
	private static final String[] subtitles = { "RC", "Revenue"

	};

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"file.xls\"");

		@SuppressWarnings("unchecked")
		Map<String, List<ProjectionVO>> exportlist = (Map<String, List<ProjectionVO>>) model.get("exportList");

	

		Map<String, CellStyle> styles = createStyles(workbook);

		// create excel xls sheet
		// Sheet sheet = workbook.createSheet("ProjectDetail");
		// sheet.setDefaultColumnWidth(30);

		Sheet sheet = workbook.createSheet("Projections");
		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		// title row
		Row titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(45);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Target Projections");
		titleCell.setCellStyle(styles.get("title"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$AA$1"));

		// header row
		Row headerRow = sheet.createRow(1);
		headerRow.setHeightInPoints(40);
		int k = 2;
		int j = 3;
		int headercellinc = 0;
		Cell headerCell;
		for (int i = 0; i < titles.length; i++) {
			headerCell = headerRow.createCell(headercellinc);
			headerCell.setCellValue(titles[i]);
			headerCell.setCellStyle(styles.get("header"));
			if (i >1) {
				
				
				++headercellinc;
				System.out.println("inside if condition");
				headerCell = headerRow.createCell(headercellinc);
				headerCell.setCellValue(titles[i]);
				headerCell.setCellStyle(styles.get("header"));
				String ref = (char) ('A' + k) + "2:" + (char) ('A' + j) + "2";
				sheet.addMergedRegion(CellRangeAddress.valueOf(ref));
				j++;
				j++;
				k++;
				k++;
			}

			headercellinc++;

		}

		// subheader row
		Row subheaderRow = sheet.createRow(2);
		subheaderRow.setHeightInPoints(40);
		Cell subheaderCell;
		int m = 2;
		for (int i = 2; i < 14; i++) {

			for (int n = 0; n < subtitles.length; n++) {
				subheaderCell = subheaderRow.createCell(m);
				subheaderCell.setCellValue(subtitles[n]);
				subheaderCell.setCellStyle(styles.get("header"));
				m++;
			}

		}

		//
		// // create style for header cells
		// CellStyle style = workbook.createCellStyle();
		// Font font = workbook.createFont();
		// font.setFontName("Arial");
		// style.setFillForegroundColor(HSSFColor.BLUE.index);
		// style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// font.setBold(true);
		// font.setColor(HSSFColor.WHITE.index);
		// style.setFont(font);
		//
		//
		// // create header row
		// Row header = sheet.createRow(0);
		// header.createCell(0).setCellValue("Project");
		// header.getCell(0).setCellStyle(style);
		// header.createCell(1).setCellValue("Tower");
		// header.getCell(1).setCellStyle(style);
		// header.createCell(2).setCellValue("Jan");
		// header.getCell(2).setCellStyle(style);
		// header.createCell(3).setCellValue("Feb");
		// header.getCell(3).setCellStyle(style);
		// header.createCell(4).setCellValue("Mar");
		// header.getCell(4).setCellStyle(style);
		// header.createCell(5).setCellValue("April");
		// header.getCell(5).setCellStyle(style);
		// header.createCell(6).setCellValue("May");
		// header.getCell(6).setCellStyle(style);
		// header.createCell(7).setCellValue("Jun");
		// header.getCell(7).setCellStyle(style);
		// header.createCell(8).setCellValue("Jul");
		// header.getCell(8).setCellStyle(style);
		// header.createCell(9).setCellValue("Aug");
		// header.getCell(9).setCellStyle(style);
		// header.createCell(10).setCellValue("Sep");
		// header.getCell(10).setCellStyle(style);
		// header.createCell(11).setCellValue("Oct");
		// header.getCell(11).setCellStyle(style);
		// header.createCell(12).setCellValue("Nov");
		// header.getCell(12).setCellStyle(style);
		// header.createCell(13).setCellValue("Dec");
		// header.getCell(13).setCellStyle(style);
		//
		//
		//

		int rowCount = 3;

		for (Map.Entry<String, List<ProjectionVO>> entry : exportlist.entrySet()) {
			String key = entry.getKey();
			List<ProjectionVO> values = entry.getValue();
			System.out.println("size of value"+values.size());
			Row exportvoRow = sheet.createRow(rowCount++);
			exportvoRow.createCell(0).setCellValue(key);
			int i=2;
			int cellincrement = 3;

			for (ProjectionVO exportvo : values) {
				
				  System.out.println("Values = " + exportvo.getMonth()+exportvo.getResource_count()+exportvo.getTower()+exportvo.getRevenue());

				exportvoRow.createCell(1).setCellValue(exportvo.getTower());
				
				//for (int i = 2; i <= values.size(); i++) 
				
				
				
				
					

					exportvoRow.createCell(i).setCellValue(exportvo.getMonth());
					System.out.println("rc is"+exportvo.getResource_count());
					
					exportvoRow.createCell(cellincrement).setCellValue(exportvo.getRevenue());
					cellincrement++;
					cellincrement++;
					i++;
					i++;
				


			}
		}

	}

	/**
	 * Create a library of cell styles
	 */
	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBold(true);
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		Font monthFont = wb.createFont();
		monthFont.setFontHeightInPoints((short) 11);
		monthFont.setColor(IndexedColors.WHITE.getIndex());
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont);
		style.setWrapText(true);
		styles.put("header", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setWrapText(true);
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		styles.put("cell", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
		styles.put("formula", style);

		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
		styles.put("formula_2", style);

		return styles;
	}

}

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

	private static final String[] titles = { "Project", "Tower", "ONSITE WON", "OFFSITE WON", "NEAR WON",
			"OFF LOCATION", "SL1", "SL2", "DIGITAL OFFERING", "PROJECT TYPE", "ON RATE", "OFF RATE", "NS RATE", "JAN",
			"FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	private static final String[] subtitles = { "ON HC", "OFF HC", "NEAR HC", "TOTAL HC", "ON REV", "OFF REV",
			"NEAR REV", "TOTAL REV"

	};

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"ProjectionSheet.xls\"");

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
		int k = 13;
		int j = 20;
		int headercellinc = 0;
		Cell headerCell;
		for (int i = 0; i < titles.length; i++) {
			headerCell = headerRow.createCell(headercellinc);
			headerCell.setCellValue(titles[i]);
			headerCell.setCellStyle(styles.get("header"));
			if (i > 12) {

				while (headercellinc < j) {

					++headercellinc;
					System.out.println("inside if condition");
					headerCell = headerRow.createCell(headercellinc);
					headerCell.setCellValue(titles[i]);
					headerCell.setCellStyle(styles.get("header"));
				}
//				String ref = (char) ('A' + k) + "2:" + (char) ('A' + j) + "2";
//				sheet.addMergedRegion(CellRangeAddress.valueOf(ref));
				j = j + 8;
				k = k + 8;
			}

			headercellinc++;

		}

		// subheader row
		Row subheaderRow = sheet.createRow(2);
		subheaderRow.setHeightInPoints(40);
		Cell subheaderCell;
		int m = 13;
		for (int i = 0; i < 12; i++) {

			for (int subtitleArray = 0; subtitleArray < subtitles.length; subtitleArray++) {
				subheaderCell = subheaderRow.createCell(m);
				subheaderCell.setCellValue(subtitles[subtitleArray]);
				subheaderCell.setCellStyle(styles.get("header"));
				m++;
			}

		}

		int rowCount = 3;

		for (Map.Entry<String, List<ProjectionVO>> entry : exportlist.entrySet()) {
			String key = entry.getKey();
			List<ProjectionVO> values = entry.getValue();
			System.out.println("size of value" + values.size());
			Row exportvoRow = sheet.createRow(rowCount++);
			exportvoRow.createCell(0).setCellValue(key);
			int i = 2;
			int cellincrement = 3;

			for (ProjectionVO exportvo : values) {

				System.out.println("Values = " + exportvo.getMonth() + exportvo.getResource_count()
						+ exportvo.getTower() + exportvo.getRevenue());

				exportvoRow.createCell(1).setCellValue(exportvo.getTower());

				// for (int i = 2; i <= values.size(); i++)

				exportvoRow.createCell(i).setCellValue(exportvo.getMonth());
				System.out.println("rc is" + exportvo.getResource_count());

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

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
			"OFF LOCATION", "SL1", "SL2", "DIGITAL OFFERING", "PROJECT TYPE", "ON RATE", "OFF RATE", "NS RATE","Probability",
			"Q1HC","Q1REV","Q2HC","Q2REV","Q3HC","Q3REV","Q4HC","Q4REV","APR",
			"MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC", "JAN", "FEB", "MAR" };
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
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$DE$1"));

		// header row
		Row headerRow = sheet.createRow(1);
		headerRow.setHeightInPoints(40);
		int k = 22;
		int j = 29;
		int headercellinc = 0;
		Cell headerCell;
		for (int i = 0; i < titles.length; i++) {
			headerCell = headerRow.createCell(headercellinc);
			headerCell.setCellValue(titles[i]);
			headerCell.setCellStyle(styles.get("header"));
			if (i > 21) {

				while (headercellinc < j) {

					++headercellinc;
					System.out.println("inside if condition");
					headerCell = headerRow.createCell(headercellinc);
					headerCell.setCellValue(titles[i]);
					headerCell.setCellStyle(styles.get("header"));
				}
			
				CellRangeAddress cellRangeAddress = new CellRangeAddress(1, 1, k, j);
				sheet.addMergedRegion(cellRangeAddress);
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
		int m = 22;
		for (int i = 0; i < 12; i++) {

			for (int subtitleArray = 0; subtitleArray < subtitles.length; subtitleArray++) {
				subheaderCell = subheaderRow.createCell(m);
				subheaderCell.setCellValue(subtitles[subtitleArray]);
				if(i==0 ||i==2||i==4||i==6||i==8||i==10){
				subheaderCell.setCellStyle(styles.get("subheader"));
				}
				if(i==1 ||i==3||i==5||i==7||i==9||i==11){
					subheaderCell.setCellStyle(styles.get("subheader1"));
					}
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
				
				exportvoRow.createCell(1).setCellValue(exportvo.getTower());
				
				String month=exportvo.getMonth();
				 int columnStartValue=0;
				   int columnEndValue=0;
				
				switch(month)
				{
			
				   case "Jan" :
					   columnStartValue=17;
					   columnEndValue=17;
					   
					   createcell(exportvoRow,columnStartValue,columnEndValue,exportvo);
				      
				      break; 
				   
				   case "Feb" :
					   columnStartValue=25;
					   columnEndValue=25;
					   
					   createcell(exportvoRow,columnStartValue,columnEndValue,exportvo);
				   
				      break; 
				
				   default : 
					   System.out.println("inside default");
				   
				}

//				System.out.println("Values = " + exportvo.getMonth() + exportvo.getResource_count()
//						+ exportvo.getTower() + exportvo.getRevenue());
//
//				
//
//				// for (int i = 2; i <= values.size(); i++)
//
//				exportvoRow.createCell(i).setCellValue(exportvo.getMonth());
//				System.out.println("rc is" + exportvo.getResource_count());
//
//				exportvoRow.createCell(cellincrement).setCellValue(exportvo.getRevenue());
//				cellincrement++;
//				cellincrement++;
//				i++;
//				i++;

			}
		}

	}

	private void createcell(Row exportvoRow,int columnStartValue,int columnEndValue,ProjectionVO exportvo) {
		
		for(int i=columnStartValue;i<=columnEndValue;i++){
			
			exportvoRow.createCell(i).setCellValue(exportvo.getRevenue());
			
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
		
		Font subheaderFont = wb.createFont();
		subheaderFont.setFontHeightInPoints((short) 11);
		subheaderFont.setColor(IndexedColors.WHITE.getIndex());
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BROWN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont);
		style.setWrapText(true);
		styles.put("subheader", style);
		

		Font subheaderFont1 = wb.createFont();
		subheaderFont1.setFontHeightInPoints((short) 11);
		subheaderFont1.setColor(IndexedColors.WHITE.getIndex());
		style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(monthFont);
		style.setWrapText(true);
		styles.put("subheader1", style);

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

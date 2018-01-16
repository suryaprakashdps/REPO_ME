package com.tcs.Repo.Export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.tcs.Repo.model.ProjectionVO;


public class ExcelView extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"file.xls\"");

        @SuppressWarnings("unchecked")
        Map<String, List<ProjectionVO> > exportlist = (Map<String, List<ProjectionVO>>) model.get("exportList");
        
        System.out.println("inside export excelview");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("ProjectDetail");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Project");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Tower");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Jan");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Feb");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Mar");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("April");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("May");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Jun");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Jul");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Aug");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("Sep");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Oct");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("Nov");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("Dec");
        header.getCell(13).setCellStyle(style);
        
 



        int rowCount = 1;
        
        for (Map.Entry<String, List<ProjectionVO>> entry : exportlist.entrySet()) {
            String key = entry.getKey();
            List<ProjectionVO> values = entry.getValue();
            Row exportvoRow =  sheet.createRow(rowCount++);
            exportvoRow.createCell(0).setCellValue(key);
   
            for(ProjectionVO exportvo:values){
            	
            	exportvoRow.createCell(1).setCellValue(exportvo.getTower());
            	
            	for (int i=2;i<=values.size();i++){
            		
            		exportvoRow.createCell(i).setCellValue(exportvo.getRevenue());
            		
            	}
       
            }
        }

   

    }

}

package excelExporter;

import java.io.IOException;

import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.adminPortal.entity.Report;
 
public class ReportExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Report> listReports;
     
    public ReportExcelExporter(List<Report> listReports) {
        this.listReports = listReports;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Reports");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Report ID", style);      
        createCell(row, 1, "Description", style);       
        createCell(row, 2, "Report Title", style);    
        createCell(row, 3, "Days until Expiration", style);
        createCell(row, 4, "Report Creation Date", style);
        createCell(row, 5, "Report Added by: ", style);
        createCell(row, 6, "Report Modified by: ", style);
        createCell(row, 7, "Report Status", style);
        createCell(row, 8, "Report Deleted by: ", style);
     
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        cell.setCellStyle(style);
        cell.setCellValue(String.valueOf(value));
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Report Report : listReports) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, Report.getReportId(), style);
            createCell(row, columnCount++, Report.getDescription(), style);
            createCell(row, columnCount++, Report.getReportTitle(), style);
            createCell(row, columnCount++, Report.getExpirationDays(), style);
            createCell(row, columnCount++, Report.getUploadedFileName(), style);
            createCell(row, columnCount++, Report.getCreationDate(), style);
            createCell(row, columnCount++, Report.getAddedBy(), style);
            createCell(row, columnCount++, Report.getModifiedBy(), style);
            createCell(row, columnCount++, Report.getStatus(), style);
            createCell(row, columnCount++, Report.getDeletedBy(), style);
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}

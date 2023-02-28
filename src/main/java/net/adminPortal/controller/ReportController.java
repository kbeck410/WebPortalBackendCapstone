package net.adminPortal.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.adminPortal.entity.Report;

import org.apache.poi.hpsf.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import excelExporter.ReportExcelExporter;
import net.adminPortal.exception.ResourceNotFoundException;
import net.adminPortal.repository.ReportRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ReportController {
	@Autowired
	private ReportRepository reportRepository;

	// get all reports
	@GetMapping("/reports")
	public List<Report> getReportList(){
		return reportRepository.findAll();
	}

	// create report rest api
	@PostMapping("/reports")
	public Report createReport(@RequestBody Report report) {
		return reportRepository.save(report);
	}

	// get report by id rest api
	@GetMapping("/reports/{reportId}")
	public ResponseEntity<Report> getReportByREPORTID(@PathVariable Long reportId) {
		Report report = reportRepository.findById(reportId)
				.orElseThrow(() -> new ResourceNotFoundException("Report does not exist with id :" + reportId));
		return ResponseEntity.ok(report);
	}

	// update report rest api

	@PutMapping("/reports/{reportId}")
	public ResponseEntity<Report> updateReport(@PathVariable Long reportId, @RequestBody Report reportDetails){
		Report report = reportRepository.findById(reportId)
				.orElseThrow(() -> new ResourceNotFoundException("Report does not exist with username :" + reportId));

		report.setReportTitle(reportDetails.getReportTitle());
		report.setDescription(reportDetails.getDescription());
		report.setStatus(reportDetails.getStatus());

		Report updatedReport = reportRepository.save(report);
		return ResponseEntity.ok(updatedReport);
	}

	// delete report rest api
	@DeleteMapping("/reports/{reportId}")
	public ResponseEntity<Map<String, Boolean>> deleteReport(@PathVariable Long reportId){
		Report report = reportRepository.findById(reportId)
				.orElseThrow(() -> new ResourceNotFoundException("Report does not exist with reportID :" + reportId));

		reportRepository.delete(report);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/reports/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String str = "20190226";
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate dateTime = LocalDate.parse(str, inputFormat);
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(dateTime.format(outputFormat));
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + dateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<Report> listReports = getReportList();
         
        ReportExcelExporter excelExporter = new ReportExcelExporter(listReports);
         
        excelExporter.export(response);    
    }  
}
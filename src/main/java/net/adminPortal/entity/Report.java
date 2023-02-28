package net.adminPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_report")
public class Report {

	@Id
	@Column(name = "reportId")
	private Long reportId;

	@Column(name = "REPORTNAME")
	private String reportTitle;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "EXPIRATIONDAYS")
	private Long expirationDays;

	@Column(name = "UPLOADEDFILENAME")
	private String uploadedFileName;

	@Column(name = "CREATIONDATE")
	private String creationDate;

	@Column(name = "ADDEDBY")
	private String addedBy;

	@Column(name = "MODIFIEDBY")
	private String modifiedBy;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DELETEDBY")
	private String deletedBy;

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(Long expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getUploadedFileName() {
		return uploadedFileName;
	}

	public void setUploadedFileName(String uploadedFileName) {
		this.uploadedFileName = uploadedFileName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	


}
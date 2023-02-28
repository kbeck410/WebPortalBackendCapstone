package net.adminPortal.entity;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_employee")
public class Employee {
	
	@Id
	@Column(name = "employeeId")
	private Long employeeId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phoneNumber;

	@Column(name = "Created")
	private String employeeCreated;

	@Column(name = "Modified")
	private String employeeModified;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Status")
	private String status;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmployeeCreated() {
		return employeeCreated;
	}

	public void setEmployeeCreated(String employeeCreated) {
		this.employeeCreated = employeeCreated;
	}

	public String getEmployeeModified() {
		return employeeModified;
	}

	public void setEmployeeModified(String employeeModified) {
		this.employeeModified = employeeModified;
	}

	public String getEmployeeStatus() {
		return status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmployeeStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

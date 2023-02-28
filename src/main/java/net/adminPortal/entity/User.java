package net.adminPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_users")
public class User {
	@Id
	@Column(name = "USERNAME")
	private Long USERNAME;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phoneNumber;

	@Column(name = "Created")
	private Integer userCreated;

	@Column(name = "Modified")
	private Integer userModified;

	@Column(name = "ISACTIVE")
	private Integer userStatus;

	@Column(name = "Password")
	private String password;

	public User() {

	}

	public User(String firstName, String lastName, String email,
				String phone, Integer userCreated, Integer userModified,
				Integer userStatus, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phone;
		this.email = email;
		this.userCreated = userCreated;
		this.userModified = userModified;
		this.userStatus = userStatus;
		this.password = password;

	}

	public Long getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(long uSERNAME) {
		USERNAME = uSERNAME;
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

	public Integer getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(Integer userCreated) {
		this.userCreated = userCreated;
	}

	public Integer getUserModified() {
		return userModified;
	}

	public void setUserModified(Integer userModified) {
		this.userModified = userModified;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}

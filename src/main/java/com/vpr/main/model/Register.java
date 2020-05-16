package com.vpr.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "register")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int userid;
	
	@NotBlank(message = "Login Id is mandatory")
	private String loginId;
	
	@NotEmpty(message = "Please provide a password")
	private String password;
	
	@NotEmpty(message = "Please provide a Confirm password")
	private String confirmPassword;
	
	@NotNull
	@Size(min=2, max=30)
	private String fullName;
	
	private String emailId;
	private long mobileNo;
	
	public Register() {
		
	}
	
	public Register(int userid, String loginId, String password, String confirmPassword, String fullName,
			String emailId, long mobileNo) {
		//super();
		this.userid = userid;
		
		this.loginId = loginId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Column(name = "login_id", nullable = false)
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Register [userid=" + userid + ", loginId=" + loginId + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", fullName=" + fullName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + "]";
	} 
	
	
	
	
}

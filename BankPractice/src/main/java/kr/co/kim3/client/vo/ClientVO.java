package kr.co.kim3.client.vo;

import java.util.Date;

public class ClientVO {

	private String cId;
	private String cName;
	private String cPassword;
	private String cPhone_num;
	private String cBirth;
	private String cAdress;
	private String cEmail;
	private Date cRegdate;
	private int cNumber;
	private int loginAttempts;
	private String accountLocked;
	private String verification_Code;
	
	public ClientVO(String cId, String cName, String cPassword, String cPhone_num, String cBirth, String cAdress,
			String cEmail, Date cRegdate, int cNumber, int loginAttempts, String accountLocked,
			String verification_Code) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPassword = cPassword;
		this.cPhone_num = cPhone_num;
		this.cBirth = cBirth;
		this.cAdress = cAdress;
		this.cEmail = cEmail;
		this.cRegdate = cRegdate;
		this.cNumber = cNumber;
		this.loginAttempts = loginAttempts;
		this.accountLocked = accountLocked;
		this.verification_Code = verification_Code;
	}
	public String getVerification_Code() {
		return verification_Code;
	}
	public void setVerification_Code(String verification_Code) {
		this.verification_Code = verification_Code;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getcPhone_num() {
		return cPhone_num;
	}
	public void setcPhone_num(String cPhone_num) {
		this.cPhone_num = cPhone_num;
	}
	public String getcBirth() {
		return cBirth;
	}
	public void setcBirth(String cBirth) {
		this.cBirth = cBirth;
	}
	public String getcAdress() {
		return cAdress;
	}
	public void setcAdress(String cAdress) {
		this.cAdress = cAdress;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public Date getcRegdate() {
		return cRegdate;
	}
	public void setcRegdate(Date cRegdate) {
		this.cRegdate = cRegdate;
	}
	public int getcNumber() {
		return cNumber;
	}
	public void setcNumber(int cNumber) {
		this.cNumber = cNumber;
	}
	public int getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	public String getAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(String accountLocked) {
		this.accountLocked = accountLocked;
	}
	@Override
	public String toString() {
		return "ClientVO [cId=" + cId + ", cName=" + cName + ", cPassword=" + cPassword + ", cPhone_num=" + cPhone_num
				+ ", cBirth=" + cBirth + ", cAdress=" + cAdress + ", cEmail=" + cEmail + ", cRegdate=" + cRegdate
				+ ", cNumber=" + cNumber + ", loginAttempts=" + loginAttempts + ", accountLocked=" + accountLocked
				+ ", verification_Code=" + verification_Code + "]";
	}
	public ClientVO(String cId, String cName, String cPassword, String cPhone_num, String cBirth, String cAdress,
			String cEmail, Date cRegdate, int cNumber, int loginAttempts, String accountLocked) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cPassword = cPassword;
		this.cPhone_num = cPhone_num;
		this.cBirth = cBirth;
		this.cAdress = cAdress;
		this.cEmail = cEmail;
		this.cRegdate = cRegdate;
		this.cNumber = cNumber;
		this.loginAttempts = loginAttempts;
		this.accountLocked = accountLocked;
	}
	public ClientVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}	

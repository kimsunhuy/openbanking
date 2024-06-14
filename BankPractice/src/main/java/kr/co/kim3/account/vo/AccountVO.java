package kr.co.kim3.account.vo;

import java.util.Date;

public class AccountVO {
    private String acNumber;
    private String acClient_id;
    private String acName;
    private int acPassword;
    private Date acRegdate;
    private int acType;
    private double acBalance;
    
    
	@Override
	public String toString() {
		return "AccountVO [acNumber=" + acNumber + ", acClient_id=" + acClient_id + ", acName=" + acName
				+ ", acPassword=" + acPassword + ", acRegdate=" + acRegdate + ", acType=" + acType + ", acBalance="
				+ acBalance + "]";
	}
	public String getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(String acNumber) {
		this.acNumber = acNumber;
	}
	public String getAcClient_id() {
		return acClient_id;
	}
	public void setAcClient_id(String acClient_id) {
		this.acClient_id = acClient_id;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public int getAcPassword() {
		return acPassword;
	}
	public void setAcPassword(int acPassword) {
		this.acPassword = acPassword;
	}
	public Date getAcRegdate() {
		return acRegdate;
	}
	public void setAcRegdate(Date acRegdate) {
		this.acRegdate = acRegdate;
	}
	public int getAcType() {
		return acType;
	}
	public void setAcType(int acType) {
		this.acType = acType;
	}
	public double getAcBalance() {
		return acBalance;
	}
	public void setAcBalance(double acBalance) {
		this.acBalance = acBalance;
	}
	public double getDailyTransferLimit() {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getMonthlyTransferLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

    // Getters and Setters
}

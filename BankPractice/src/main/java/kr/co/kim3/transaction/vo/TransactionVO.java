package kr.co.kim3.transaction.vo;

import java.util.Date;

public class TransactionVO {
    private Long tId;
    private String tAccount_number;
    private String tName;
    private double tAmount;
    private Date tDate;
    private int tType;
    
    
    
	@Override
	public String toString() {
		return "TransactionVO [tId=" + tId + ", tAccount_number=" + tAccount_number + ", tName=" + tName + ", tAmount="
				+ tAmount + ", tDate=" + tDate + ", tType=" + tType + "]";
	}
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String gettAccount_number() {
		return tAccount_number;
	}
	public void settAccount_number(String tAccount_number) {
		this.tAccount_number = tAccount_number;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public double gettAmount() {
		return tAmount;
	}
	public void settAmount(double tAmount) {
		this.tAmount = tAmount;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public int gettType() {
		return tType;
	}
	public void settType(int tType) {
		this.tType = tType;
	}

    // Getters and Setters
}

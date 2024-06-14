package kr.co.kim3.deposit.vo;

import java.util.Date;

public class DepositVO {
    private int dsType;
    private String dsName;
    private String dsDetail;
    private double dsInterest;
    private Date dsRegdate;
    private Date dsExpiration_date;
    private Date dsPay_date;
    
    
    
	@Override
	public String toString() {
		return "DepositVO [dsType=" + dsType + ", dsName=" + dsName + ", dsDetail=" + dsDetail + ", dsInterest="
				+ dsInterest + ", dsRegdate=" + dsRegdate + ", dsExpiration_date=" + dsExpiration_date + ", dsPay_date="
				+ dsPay_date + "]";
	}
	public int getDsType() {
		return dsType;
	}
	public void setDsType(int dsType) {
		this.dsType = dsType;
	}
	public String getDsName() {
		return dsName;
	}
	public void setDsName(String dsName) {
		this.dsName = dsName;
	}
	public String getDsDetail() {
		return dsDetail;
	}
	public void setDsDetail(String dsDetail) {
		this.dsDetail = dsDetail;
	}
	public double getDsInterest() {
		return dsInterest;
	}
	public void setDsInterest(double dsInterest) {
		this.dsInterest = dsInterest;
	}
	public Date getDsRegdate() {
		return dsRegdate;
	}
	public void setDsRegdate(Date dsRegdate) {
		this.dsRegdate = dsRegdate;
	}
	public Date getDsExpiration_date() {
		return dsExpiration_date;
	}
	public void setDsExpiration_date(Date dsExpiration_date) {
		this.dsExpiration_date = dsExpiration_date;
	}
	public Date getDsPay_date() {
		return dsPay_date;
	}
	public void setDsPay_date(Date dsPay_date) {
		this.dsPay_date = dsPay_date;
	}

    // Getters and Setters
}

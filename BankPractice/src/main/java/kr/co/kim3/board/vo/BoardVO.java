package kr.co.kim3.board.vo;

import java.util.Date;

public class BoardVO {
    private String bType;
    private int bNumber;
    private String bTitle;
    private String bWriter;
    private String bContent;
    private Date bRegdate;
    
    
    
	@Override
	public String toString() {
		return "BoardVO [bType=" + bType + ", bNumber=" + bNumber + ", bTitle=" + bTitle + ", bWriter=" + bWriter
				+ ", bContent=" + bContent + ", bRegdate=" + bRegdate + "]";
	}
	public String getbType() {
		return bType;
	}
	public void setbType(String bType) {
		this.bType = bType;
	}
	public int getbNumber() {
		return bNumber;
	}
	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbRegdate() {
		return bRegdate;
	}
	public void setbRegdate(Date bRegdate) {
		this.bRegdate = bRegdate;
	}

    // Getters and Setters
}

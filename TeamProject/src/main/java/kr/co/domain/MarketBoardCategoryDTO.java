package kr.co.domain;

import java.io.Serializable;

public class MarketBoardCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bno;
	private String title;
	private int cno;
	private String gno;
	private String regDate;
	private String cname;
	
	public MarketBoardCategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public MarketBoardCategoryDTO(int bno, String title, int cno, String gno, String regDate, String cname) {
		super();
		this.bno = bno;
		this.title = title;
		this.cno = cno;
		this.gno = gno;
		this.regDate = regDate;
		this.cname = cname;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

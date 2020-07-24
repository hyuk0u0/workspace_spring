package kr.co.domain;

import java.io.Serializable;

public class MarketBoardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bno;
	private String title;
	private int cno;
	private String gno;
	private String regDate;
	
	public MarketBoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public MarketBoardDTO(int bno, String title, int cno, String gno, String regDate) {
		super();
		this.bno = bno;
		this.title = title;
		this.cno = cno;
		this.gno = gno;
		this.regDate = regDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarketBoardDTO other = (MarketBoardDTO) obj;
		if (bno != other.bno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarketBoardDTO [bno=" + bno + ", title=" + title + ", cno=" + cno + ", gno=" + gno + ", regDate="
				+ regDate + "]";
	}
	
	
	
}

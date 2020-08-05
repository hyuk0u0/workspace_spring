package kr.co.domain;

import java.io.Serializable;

public class BoardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bno;
	private String title;
	private int cno;
	private int gno;
	private String regDate;
	private String[] files;
	private String gname;
	private int price;
	private String cname;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public BoardDTO(int bno, String title, int cno, int gno, String regDate, String[] files) {
		super();
		this.bno = bno;
		this.title = title;
		this.cno = cno;
		this.gno = gno;
		this.regDate = regDate;
		this.files = files;
	}
	
	



	public BoardDTO(int bno, String title, int cno, int gno, String regDate, String[] files, String gname, int price,
			String cname) {
		super();
		this.bno = bno;
		this.title = title;
		this.cno = cno;
		this.gno = gno;
		this.regDate = regDate;
		this.files = files;
		this.gname = gname;
		this.price = price;
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

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
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
	
	

	public String[] getFiles() {
		return files;
	}



	public void setFiles(String[] files) {
		this.files = files;
	}

	
	


	public String getGname() {
		return gname;
	}



	public void setGname(String gname) {
		this.gname = gname;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
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
		BoardDTO other = (BoardDTO) obj;
		if (bno != other.bno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", cno=" + cno + ", gno=" + gno + ", regDate=" + regDate
				+ "]";
	}
	
	
	
}

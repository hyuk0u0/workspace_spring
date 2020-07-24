package kr.co.domain;

import java.io.Serializable;

public class MarketBoardCategoryToyDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int bno;
	private String title;
	private int cno;
	private String gno;
	private String regDate;
	private String cname;
	private String gname;
	private int price;
	private String id;
	private int pno;
	private String deliveryCode;
	
	public MarketBoardCategoryToyDTO() {
		// TODO Auto-generated constructor stub
	}

	public MarketBoardCategoryToyDTO(int bno, String title, int cno, String gno, String regDate, String cname,
			String gname, int price) {
		super();
		this.bno = bno;
		this.title = title;
		this.cno = cno;
		this.gno = gno;
		this.regDate = regDate;
		this.cname = cname;
		this.gname = gname;
		this.price = price;
	}
	
	
	
	



	
	
	public MarketBoardCategoryToyDTO(int bno, String title, int cno, String gno, String regDate, String cname,
			String gname, int price, String id, int pno, String deliveryCode) {
		super();
		this.bno = bno;
		this.title = title;
		this.cno = cno;
		this.gno = gno;
		this.regDate = regDate;
		this.cname = cname;
		this.gname = gname;
		this.price = price;
		this.id = id;
		this.pno = pno;
		this.deliveryCode = deliveryCode;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MarketBoardCategoryToyDTO [bno=" + bno + ", title=" + title + ", cno=" + cno + ", gno=" + gno
				+ ", regDate=" + regDate + ", cname=" + cname + ", gname=" + gname + ", price=" + price + "]";
	}
	
	
}

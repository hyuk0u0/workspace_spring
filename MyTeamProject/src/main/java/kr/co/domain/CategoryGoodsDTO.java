package kr.co.domain;

public class CategoryGoodsDTO {
	private int gno;
	private int cno;
	private String gname;
	private int price;
	private String cname;
	
	public CategoryGoodsDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryGoodsDTO(int gno, int cno, String gname, int price, String cname) {
		super();
		this.gno = gno;
		this.cno = cno;
		this.gname = gname;
		this.price = price;
		this.cname = cname;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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
		result = prime * result + gno;
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
		CategoryGoodsDTO other = (CategoryGoodsDTO) obj;
		if (gno != other.gno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryGoodsDTO [gno=" + gno + ", cno=" + cno + ", gname=" + gname + ", price=" + price + ", cname="
				+ cname + "]";
	}
	
	
}

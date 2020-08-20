package kr.co.domain;

public class GoodsDTO {
	
	private int goodsNum;
	private int categoryNum;
	private String goodsName;
	private int price;
	
	public GoodsDTO() {
		// TODO Auto-generated constructor stub
	}

	public GoodsDTO(int goodsNum, int categoryNum, String goodsName, int price) {
		super();
		this.goodsNum = goodsNum;
		this.categoryNum = categoryNum;
		this.goodsName = goodsName;
		this.price = price;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goodsNum;
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
		GoodsDTO other = (GoodsDTO) obj;
		if (goodsNum != other.goodsNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsDTO [goodsNum=" + goodsNum + ", categoryNum=" + categoryNum + ", goodsName=" + goodsName
				+ ", price=" + price + "]";
	}
	
	
}

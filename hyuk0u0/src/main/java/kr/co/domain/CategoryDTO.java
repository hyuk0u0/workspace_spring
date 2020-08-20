package kr.co.domain;

public class CategoryDTO {
	
	private int CategoryNum;
	private String CategoryName;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(int categoryNum, String categoryName) {
		super();
		CategoryNum = categoryNum;
		CategoryName = categoryName;
	}

	public int getCategoryNum() {
		return CategoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		CategoryNum = categoryNum;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CategoryNum;
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
		CategoryDTO other = (CategoryDTO) obj;
		if (CategoryNum != other.CategoryNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryDTO [CategoryNum=" + CategoryNum + ", CategoryName=" + CategoryName + "]";
	}
	
	
}

package kr.co.domain;

public class CategoryDTO {
	
	private int cno;
	private String cname;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(int cno, String cname) {
		super();
		this.cno = cno;
		this.cname = cname;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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
		result = prime * result + cno;
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
		if (cno != other.cno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoryDTO [cno=" + cno + ", cname=" + cname + "]";
	}
	
	
}

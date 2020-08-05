package kr.co.domain;

public class AttachDTO {
	
	private int uno;
	private int bno;
	private String fullName;
	
	public AttachDTO() {
		// TODO Auto-generated constructor stub
	}

	public AttachDTO(int uno, int bno, String fullName) {
		super();
		this.uno = uno;
		this.bno = bno;
		this.fullName = fullName;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uno;
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
		AttachDTO other = (AttachDTO) obj;
		if (uno != other.uno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttachDTO [uno=" + uno + ", bno=" + bno + ", fullName=" + fullName + "]";
	}
	
	
}

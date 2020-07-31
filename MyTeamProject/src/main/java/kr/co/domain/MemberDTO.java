package kr.co.domain;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String uname;
	private int phone;
	private String addr;
	private String autority;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String id, String pw, String uname, int phone, String addr, String autority) {
		super();
		this.id = id;
		this.pw = pw;
		this.uname = uname;
		this.phone = phone;
		this.addr = addr;
		this.autority = autority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAutority() {
		return autority;
	}

	public void setAutority(String autority) {
		this.autority = autority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", uname=" + uname + ", phone=" + phone + ", addr=" + addr
				+ ", autority=" + autority + "]";
	}
	
	
	
	
}

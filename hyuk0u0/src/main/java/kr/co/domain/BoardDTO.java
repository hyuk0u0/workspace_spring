package kr.co.domain;

import java.io.Serializable;
import java.util.Arrays;

public class BoardDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int boardNum;
	private String title;
	private String fileName;
	private int categoryNum;
	private int goodsNum;
	private String regDate;
	private String[] files;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int boardNum, String title, String fileName, int categoryNum, int goodsNum, String regDate,
			String[] files) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.fileName = fileName;
		this.categoryNum = categoryNum;
		this.goodsNum = goodsNum;
		this.regDate = regDate;
		this.files = files;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNum;
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
		if (boardNum != other.boardNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", title=" + title + ", fileName=" + fileName + ", categoryNum="
				+ categoryNum + ", goodsNum=" + goodsNum + ", regDate=" + regDate + ", files=" + Arrays.toString(files)
				+ "]";
	}
	
	
	
	
}

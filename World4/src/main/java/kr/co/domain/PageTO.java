package kr.co.domain;

import java.util.List;

public class PageTO {
	private int curPage = 1; // 현재 페이지!
	private int perPage = 10; // 한페이지에 게시물 10개씩 보이게!
	private int pageLine = 10; // 페이지 개수 10개!
	private int amount; // 총게시물
	private int totalPage; // 총 페이지수
	private int startNum; // 시작하는 rownum값
	private int endNum; // 끝나는 rownum값
	private int beginPageNum; // 시작 페이징 번호
	private int stopPageNum; // 끝 페이징 번호
	
	private List<BoardVO> list; // 화면에 출력할 리스트!
	
	public PageTO() {
		executeAll();
	}
	
	
	
	public PageTO(int curPage) {
		super();
		this.curPage = curPage;
		executeAll();
	}

	public int getCurPage() {
		return curPage;
	}



	public void setCurPage(int curPage) {
		this.curPage = curPage;
		executeAll();
	}



	public int getPerPage() {
		return perPage;
	}



	public void setPerPage(int perPage) {
		this.perPage = perPage;
		executeAll();
	}



	public int getPageLine() {
		return pageLine;
	}



	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		executeAll();
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
		executeAll();
	}



	public int getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public int getStartNum() {
		return startNum;
	}



	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}



	public int getEndNum() {
		return endNum;
	}



	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}



	public int getBeginPageNum() {
		return beginPageNum;
	}



	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}



	public int getStopPageNum() {
		return stopPageNum;
	}



	public void setStopPageNum(int stopPageNum) {
		this.stopPageNum = stopPageNum;
	}



	public List<BoardVO> getList() {
		return list;
	}



	public void setList(List<BoardVO> list) {
		this.list = list;
	}



	private void executeAll() {
		totalPage = (amount - 1) / perPage + 1;
		
		startNum = (curPage - 1) * perPage + 1;
		endNum = curPage * perPage;
		if(endNum > amount) {
			endNum = amount;
		}
		
		beginPageNum = ((curPage - 1) / pageLine ) * pageLine + 1;
		stopPageNum = beginPageNum + (pageLine - 1);
		if(stopPageNum > totalPage) {
			stopPageNum = totalPage;
		}
	}
}

package com.yr.util;

public class PageMaker {
	// 페이지 처리
	
	
	private int perPage=10;
	
	private Integer curPage;
	private String kind;	// title, writer, contents
	private String search;
	
	//page
	private int totalBlock;
	private int curBlock;
	private int startNum;
	private int lastNum;
	
	//row
	private int startRow;
	private int lastRow;
	
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
		if(curPage==null)
			this.curPage=1;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search==null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	
	//startRow, lastRow
	public void makeRow() {
		this.startRow=(this.getCurPage()-1)*perPage+1;
		this.lastRow = this.curPage*perPage;
	}
	
	public void makePage(int totalCount) {
		//1. 전체 글의 개수
		//2. totalPage 수 구하기
		int totalPage =totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		//3. totalBlock
		int perBlock=5;
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			this.totalBlock++;
		}
		//4. curPage 를 이용해서  curBlock 
		this.curBlock=curPage/perBlock;
		if(this.curPage%perBlock !=0) {
			this.curBlock++;
		}
		//5. startNum, lastNum
		this.startNum=(this.curBlock-1)*perBlock+1;
		this.lastNum=this.curBlock*perBlock;
		
		//6. 현재 블럭curBlock 이 마지막 블럭totalBlock 일 때
		if(this.curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

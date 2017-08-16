package com.pojo;

public class Paging {
	//总条数
	private int count;
	//第几页
	private int page;
	//开始条数
	private int startCount;
	//每页几条
	private int pageCount;
	//共多少页
	private int countPage;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartCount() {
		return (page-1)*pageCount==0?0:(page-1)*pageCount;
	}
	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCountPage() {
		return count%pageCount==0?count/pageCount:count/pageCount+1;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	
}

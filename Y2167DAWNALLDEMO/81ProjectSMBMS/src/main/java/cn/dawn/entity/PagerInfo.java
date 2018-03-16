package cn.dawn.entity;

import java.util.ArrayList;
import java.util.List;

public class PagerInfo<T> {
	private int totalPage;
	private int totalSize;
	private int pageSize;
	private int pageIndex;
	private String Url;
	private List<T> lists=new ArrayList<T>();

	/**
	 * @return the lists
	 */
	public List<T> getLists() {
		return lists;
	}
	/**
	 * @param lists the lists to set
	 */
	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		int total=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
		
		return total;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the totalSize
	 */
	public int getTotalSize() {
		return totalSize;
	}
	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return Url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		Url = url;
	}
	
	
}

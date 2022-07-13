package com.tptransversal.rdvvaksiny.model;

import java.util.List;

public class Docs<T> {
	List<T> docs;
	int totalDocs = 0;
	int limit = 0;
	int page = 0;
	int totalPages = 0;
	int pagingCounter = 0;
	boolean hasPrevPage = false;
	boolean hasNextPage = false;
	int prevPage = 0;
	int nextPage = 0;
	
	public Docs() {}

	public Docs(List<T> docs, int totalDocs, int limit, int page, int totalPages, int pagingCounter, boolean hasPrevPage,boolean hasNextPage, int prevPage, int nextPage) {
		this.docs = docs;
		this.totalDocs = totalDocs;
		this.limit = limit;
		this.page = page;
		this.totalPages = totalPages;
		this.pagingCounter = pagingCounter;
		this.hasPrevPage = hasPrevPage;
		this.hasNextPage = hasNextPage;
		if(prevPage<=0) {this.prevPage = 0;}else {this.prevPage = prevPage;}
		this.nextPage = nextPage;
	}

	public List<T> getDocs() {
		return docs;
	}

	public void setDocs(List<T> docs) {
		this.docs = docs;
	}

	public int getTotalDocs() {
		return totalDocs;
	}

	public void setTotalDocs(int totalDocs) {
		this.totalDocs = totalDocs;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPagingCounter() {
		return pagingCounter;
	}

	public void setPagingCounter(int pagingCounter) {
		this.pagingCounter = pagingCounter;
	}

	public boolean isHasPrevPage() {
		return hasPrevPage;
	}

	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
}

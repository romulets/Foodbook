package com.foodbook.modelviews;

public class SearchForm {

	private String query;

	public SearchForm() {
		query = "";
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		if(query == null) return;
		this.query = query.trim();
	}
	
}

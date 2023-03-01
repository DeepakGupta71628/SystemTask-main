package com.msil.sysTask.dto;

public class FilterRequestDTO {
	private Integer schemeId;
	private String filter;
	public Integer getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public FilterRequestDTO(Integer schemeId, String filter) {
		super();
		this.schemeId = schemeId;
		this.filter = filter;
	}
	public FilterRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

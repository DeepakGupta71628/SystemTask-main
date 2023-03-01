package com.msil.sysTask.dto;

public class MFdataDTO {
	String schemeName;
	Integer schemeCode ;
	
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public Integer getSchemeCode() {
		return schemeCode;
	}
	public void setSchemeCode(Integer schemeCode) {
		this.schemeCode = schemeCode;
	}
	public MFdataDTO(String schemeName, Integer schemeCode) {
		super();
		this.schemeName = schemeName;
		this.schemeCode = schemeCode;
	}
	public MFdataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

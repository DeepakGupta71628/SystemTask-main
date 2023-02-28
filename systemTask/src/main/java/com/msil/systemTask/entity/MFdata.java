package com.msil.systemTask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  (name="mfdata")
public class MFdata {
	@Id
	String schemeName;
	Integer schemeCode;
	
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
	public MFdata(String schemeName, Integer schemeCode) {
		super();
		this.schemeName = schemeName;
		this.schemeCode = schemeCode;
	}
	public MFdata() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

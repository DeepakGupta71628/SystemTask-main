package com.msil.systemTask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MFdata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

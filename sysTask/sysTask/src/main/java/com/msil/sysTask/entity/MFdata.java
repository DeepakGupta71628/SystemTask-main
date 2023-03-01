package com.msil.sysTask.entity;

import javax.persistence.Entity;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.Table;

//@Document  (collection="mfdata")

@Entity  
@Table(name="mfdata")
public class MFdata {
	
	
	@Id
	//@Field("_id")
	Integer schemeCode;
	String schemeName;
	
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

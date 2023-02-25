package com.msil.systemTask.dto;

public class MFdataWithFilterDTO {
	
	private String fund_house;
	private Integer scheme_code;
	private String scheme_name;
	
	private FilterdDateNav datenav;

	public String getFund_house() {
		return fund_house;
	}

	public void setFund_house(String fund_house) {
		this.fund_house = fund_house;
	}

	public Integer getScheme_code() {
		return scheme_code;
	}

	public void setScheme_code(Integer scheme_code) {
		this.scheme_code = scheme_code;
	}

	public String getScheme_name() {
		return scheme_name;
	}

	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}

	public FilterdDateNav getDatenav() {
		return datenav;
	}

	public void setDatenav(FilterdDateNav datenav) {
		this.datenav = datenav;
	}

	public MFdataWithFilterDTO(String fund_house, Integer scheme_code, String scheme_name, FilterdDateNav datenav) {
		super();
		this.fund_house = fund_house;
		this.scheme_code = scheme_code;
		this.scheme_name = scheme_name;
		this.datenav = datenav;
	}

	public MFdataWithFilterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

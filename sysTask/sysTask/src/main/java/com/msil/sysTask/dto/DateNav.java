package com.msil.sysTask.dto;



public class DateNav {
	private String date;
	private Float nav;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getNav() {
		return nav;
	}
	public void setNav(Float nav) {
		this.nav = nav;
	}
	public DateNav(String date, Float nav) {
		super();
		this.date = date;
		this.nav = nav;
	}
	public DateNav() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

package com.msil.sysTask.dto;

import java.util.List;

public class FilterdDateNav {
	private List<String> date;
	private List<Float> nav;
	public List<String> getDate() {
		return date;
	}
	public void setDate(List<String> date) {
		this.date = date;
	}
	public List<Float> getNav() {
		return nav;
	}
	public void setNav(List<Float> nav) {
		this.nav = nav;
	}
	public FilterdDateNav(List<String> date, List<Float> nav) {
		super();
		this.date = date;
		this.nav = nav;
	}
	public FilterdDateNav() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

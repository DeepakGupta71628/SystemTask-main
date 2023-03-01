package com.msil.sysTask.dto;

import java.util.List;

public class MFCompleteData {
	private Scheme meta;
	private List<DateNav> data;
	
	public Scheme getMeta() {
		return meta;
	}
	public void setMeta(Scheme meta) {
		this.meta = meta;
	}
	public List<DateNav> getData() {
		return data;
	}
	public void setData(List<DateNav> data) {
		this.data = data;
	}
	public MFCompleteData(Scheme meta, List<DateNav> data) {
		super();
		this.meta = meta;
		this.data = data;
	}
	public MFCompleteData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}

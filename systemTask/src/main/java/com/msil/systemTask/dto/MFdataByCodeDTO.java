package com.msil.systemTask.dto;

import java.util.List;

public class MFdataByCodeDTO {
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
	public MFdataByCodeDTO(Scheme meta, List<DateNav> data) {
		super();
		this.meta = meta;
		this.data = data;
	}
	public MFdataByCodeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}

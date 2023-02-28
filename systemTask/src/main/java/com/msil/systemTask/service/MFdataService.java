package com.msil.systemTask.service;

import java.text.ParseException;

import com.msil.systemTask.dto.FilterRequestDTO;
import com.msil.systemTask.dto.MFdataByCodeDTO;
import com.msil.systemTask.dto.MFdataWithFilterDTO;
import com.msil.systemTask.exception.MFException;

public interface MFdataService {
	public MFdataByCodeDTO getMFdataBySchemeName(String  schemeName) throws MFException;
	public MFdataWithFilterDTO getmfdataByFilter(FilterRequestDTO dto) throws MFException, ParseException;
	public void saveMfDataByApiCall() throws MFException;
}

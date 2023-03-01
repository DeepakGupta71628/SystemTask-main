package com.msil.sysTask.service;

import java.text.ParseException;

import com.msil.sysTask.dto.FilterRequestDTO;
import com.msil.sysTask.dto.MFCompleteData;
import com.msil.sysTask.dto.MFdataWithFilterDTO;
import com.msil.sysTask.exception.MFException;


public interface MFdataService {
	public MFCompleteData getMFdataBySchemeName(String schemeName) throws MFException;
	public MFdataWithFilterDTO getmfdataByFilter(FilterRequestDTO dto) throws MFException, ParseException;
	public void saveMfDataByApiCall() throws MFException;
//	public List<MFdata> saveMfDataByApiCall() throws MFException;
}

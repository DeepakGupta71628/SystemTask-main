package com.msil.sysTask.api;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msil.sysTask.dto.FilterRequestDTO;
import com.msil.sysTask.dto.MFCompleteData;
import com.msil.sysTask.dto.MFdataWithFilterDTO;
import com.msil.sysTask.exception.MFException;
import com.msil.sysTask.service.MFdataService;


@RestController
@RequestMapping("/mfdata")
@CrossOrigin
public class MFdataControllerAPI {
	
	@Autowired
	private MFdataService mFdataService;
	
	@GetMapping("/add-all")
	public ResponseEntity<String> save() throws MFException {
		
		mFdataService.saveMfDataByApiCall();
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
//	@GetMapping("/add-all")
//	public ResponseEntity<List<MFdata>> save() throws MFException {
//		
//		List<MFdata> allMfData=mFdataService.saveMfDataByApiCall();
//		return new ResponseEntity<>(allMfData, HttpStatus.OK);
//	}
	
	@GetMapping("/get/{schemeName}")
	public ResponseEntity<MFCompleteData> getmfdataBySchemeName(@PathVariable String schemeName) throws MFException {

		MFCompleteData mfdataScheme = mFdataService.getMFdataBySchemeName(schemeName);
		return new ResponseEntity<>(mfdataScheme, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/get-by-filter")
	public ResponseEntity<MFdataWithFilterDTO> getmfdataByFilter(@RequestBody  FilterRequestDTO dto) throws MFException, ParseException {
		MFdataWithFilterDTO mfdataFilteredScheme = mFdataService.getmfdataByFilter(dto);
		return new ResponseEntity<>(mfdataFilteredScheme, HttpStatus.OK);
	}

}

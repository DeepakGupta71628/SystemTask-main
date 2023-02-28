package com.msil.systemTask.api;

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
import com.msil.systemTask.dto.FilterRequestDTO;
import com.msil.systemTask.dto.MFdataByCodeDTO;
import com.msil.systemTask.dto.MFdataWithFilterDTO;
import com.msil.systemTask.exception.MFException;
import com.msil.systemTask.service.MFdataService;

@RestController
@RequestMapping("/mfdata")
public class MFdataControllerAPI {
	
	@Autowired
	private MFdataService mFdataService;
	
	@GetMapping("/add-all")
	public ResponseEntity<String> save() throws MFException {
		
		mFdataService.saveMfDataByApiCall();
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@GetMapping("/get/{schemeName}")
	public ResponseEntity<MFdataByCodeDTO> getmfdataBySchemeName(@PathVariable String schemeName) throws MFException {
		System.out.println("hitting");
		MFdataByCodeDTO mfdataScheme = mFdataService.getMFdataBySchemeName("DSP Bond Fund - IDCW");
		return new ResponseEntity<>(mfdataScheme, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/get-by-filter")
	public ResponseEntity<MFdataWithFilterDTO> getmfdataByFilter(@RequestBody  FilterRequestDTO dto) throws MFException, ParseException {
		MFdataWithFilterDTO mfdataFilteredScheme = mFdataService.getmfdataByFilter(dto);
		return new ResponseEntity<>(mfdataFilteredScheme, HttpStatus.OK);
	}

}

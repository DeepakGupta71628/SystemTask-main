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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.msil.systemTask.dto.FilterRequestDTO;
import com.msil.systemTask.dto.MFdataByCodeDTO;
import com.msil.systemTask.dto.MFdataWithFilterDTO;
import com.msil.systemTask.exception.MFException;
import com.msil.systemTask.service.MFdataService;

@RestController
@CrossOrigin
@RequestMapping(value = "/mfdata")
public class MFdataControllerAPI {
	
	@Autowired
	private MFdataService mFdataService;
	
	@GetMapping(value = "/get/{schemeName}")
	public ResponseEntity<MFdataByCodeDTO> getmfdataBySchemeName(@PathVariable String schemeName) throws MFException {
		MFdataByCodeDTO mfdataScheme = mFdataService.getMFdataBySchemeName(schemeName);
		return new ResponseEntity<>(mfdataScheme, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-by-filter")
	public ResponseEntity<MFdataWithFilterDTO> getmfdataByFilter(@RequestBody  FilterRequestDTO dto) throws MFException, ParseException {
		MFdataWithFilterDTO mfdataFilteredScheme = mFdataService.getmfdataByFilter(dto);
		return new ResponseEntity<>(mfdataFilteredScheme, HttpStatus.OK);
	}

}

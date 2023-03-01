package com.msil.sysTask.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.msil.sysTask.dto.DateNav;
import com.msil.sysTask.dto.FilterRequestDTO;
import com.msil.sysTask.dto.FilterdDateNav;
import com.msil.sysTask.dto.MFCompleteData;
import com.msil.sysTask.dto.MFdataDTO;
import com.msil.sysTask.dto.MFdataWithFilterDTO;
import com.msil.sysTask.entity.MFdata;
import com.msil.sysTask.exception.MFException;
import com.msil.sysTask.repository.MFdataRepository;
import com.msil.sysTask.util.SuitConstant;




@Service(value = "mfSchemeService")
@Transactional
public class MFdataServiceImpl implements MFdataService{

	@Autowired
	private MFdataRepository mfDataRepository;
	
	@Override
	public void saveMfDataByApiCall() throws MFException {
		// TODO Auto-generated method stub
		List<MFdata> allMfData=getAllmfdata();
		System.out.println("running...");	
		//mfDataRepository.save(new MFdata("checked data",1234567));
		mfDataRepository.saveAll(allMfData);
	}
	
	@Override
	public MFCompleteData getMFdataBySchemeName(String schemeName) throws MFException {
		// TODO Auto-generated method stub
		Optional<MFdata> optional= mfDataRepository.findBySchemeName(schemeName);

		//MFdata mfdata = optional.orElseThrow(() -> new MFException("Service.SCHEME_MF_NOT_FOUND"));
		
		//searching scheme data with scheme code
		//MFCompleteData completeScheme=getMFdataBySchemeCode(mfdata.getSchemeCode());
		MFCompleteData completeScheme=getMFdataBySchemeCode(100077);
		
		return completeScheme;
	}
	
	
	//service for filter search
	public MFdataWithFilterDTO getmfdataByFilter(FilterRequestDTO dto) throws MFException, ParseException{
		
		MFCompleteData completeScheme=getMFdataBySchemeCode(dto.getSchemeId());

		//for filtring nav dev
		MFdataWithFilterDTO filtredDto=new MFdataWithFilterDTO();
		
		filtredDto.setFund_house(completeScheme.getMeta().getFund_house());
		filtredDto.setScheme_code(completeScheme.getMeta().getScheme_code());
		filtredDto.setScheme_name(completeScheme.getMeta().getScheme_name());
		filtredDto.setDatenav(filter(completeScheme.getData(),dto.getFilter()));
		
		
		
		return filtredDto;
		
	}
	
	private FilterdDateNav filter(List<DateNav> data, String filter) throws ParseException {
		// TODO Auto-generated method stub
		FilterdDateNav dateNav=new FilterdDateNav();
		for(DateNav dn:data) {
			if(filter.equals("1W" )) {
				addDateNav(data,dateNav,7);
			}else if(filter.equals("1M")) {
				addDateNav(data,dateNav,30);
			}else if(filter.equals("1Y")) {
				addDateNav(data,dateNav,365);
			}else if(filter.equals("5y")) {
				addDateNav(data,dateNav,365*5);
			}
		}
		
		
		return dateNav;
	}

	private void addDateNav(List<DateNav> data, FilterdDateNav dateNav, int days) {
		// TODO Auto-generated method stub
		dateNav.setDate(new ArrayList<String>());
		dateNav.setNav(new ArrayList<Float>());
		
		for(int i=0;i<days && i<data.size();i++) {
			dateNav.getDate().add(data.get(i).getDate());
			dateNav.getNav().add(data.get(i).getNav());
		}
		
	}

	//Creating rest template obj to get json response
	private MFCompleteData getMFdataBySchemeCode(Integer schemeCode) {
		// TODO Auto-generated method stub
		String url=SuitConstant.uri+"/"+schemeCode;
		
		RestTemplate restTemplate=new RestTemplate();
		
		return restTemplate.getForObject(url, MFCompleteData.class);
	}
	
	private List<MFdata> getAllmfdata(){
		RestTemplate restTemplate=new RestTemplate();
		String url=SuitConstant.uri;
		
		ResponseEntity<MFdata[]> response=restTemplate.getForEntity(url,MFdata[].class );
		MFdata[] allMFData=response.getBody();
		System.out.println(response);
		
		
		
		
		return  Arrays.asList(allMFData);
	}




}

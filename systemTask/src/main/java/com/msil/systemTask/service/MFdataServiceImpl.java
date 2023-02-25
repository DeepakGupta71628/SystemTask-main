package com.msil.systemTask.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.msil.systemTask.dto.DateNav;
import com.msil.systemTask.dto.FilterRequestDTO;
import com.msil.systemTask.dto.FilterdDateNav;
import com.msil.systemTask.dto.MFdataByCodeDTO;
import com.msil.systemTask.dto.MFdataWithFilterDTO;
import com.msil.systemTask.entity.MFdata;
import com.msil.systemTask.exception.MFException;
import com.msil.systemTask.repository.MFdataRepository;
import com.msil.util.SuitConstant;


@Service(value = "mfSchemeService")
@Transactional
public class MFdataServiceImpl implements MFdataService{

	@Autowired
	private MFdataRepository mfDataRepository;
	
	@Override
	public MFdataByCodeDTO getMFdataBySchemeName(String schemeName) throws MFException {
		// TODO Auto-generated method stub
		Optional<MFdata> optional = mfDataRepository.findById(schemeName);
		MFdata mfdata = optional.orElseThrow(() -> new MFException("Service.SCHEME_MF_NOT_FOUND"));
		
		//searching scheme data with scheme code
		MFdataByCodeDTO completeScheme=getMFdataBySchemeCode(mfdata.getSchemeCode());
		
		
		return completeScheme;
	}
	
	
	//service for filter search
	public MFdataWithFilterDTO getmfdataByFilter(FilterRequestDTO dto) throws MFException, ParseException{
		
		MFdataByCodeDTO completeScheme=getMFdataBySchemeCode(dto.getSchemeId());
		
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
		
		//not able to understand filtration criteria.
		Date date = new Date();
		SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy");
		 String str = obj.format(date);
		
	 
        
       
		
		for(DateNav dn:data) {
			Date date1 = obj.parse(dn.getDate());   
	        Date date2 = obj.parse(str);//system date
	        long time_difference = date2.getTime() - date1.getTime();
			long days_difference = (time_difference / (1000*60*60*24)) % 365;
			long years_difference = (time_difference / (1000l*60*60*24*365));
	        
			
			if(filter.equals("1W" )&& days_difference<=7) {
				dateNav.getDate().add(dn.getDate());
				dateNav.getNav().add(dn.getNav());
			}else if(filter.equals("1M")&& days_difference<=30) {
				dateNav.getDate().add(dn.getDate());
				dateNav.getNav().add(dn.getNav());
			}else if(filter.equals("1Y")&& years_difference<=1) {
				dateNav.getDate().add(dn.getDate());
				dateNav.getNav().add(dn.getNav());
			}else if(filter.equals("5y")&& years_difference<=5) {
				dateNav.getDate().add(dn.getDate());
				dateNav.getNav().add(dn.getNav());
			}
		}
		
		return dateNav;
	}


	//Creating rest template obj to get json response
	private MFdataByCodeDTO getMFdataBySchemeCode(Integer schemeCode) {
		// TODO Auto-generated method stub
		String url=SuitConstant.uri+schemeCode;
		
		RestTemplate restTemplate=new RestTemplate();
		
		return restTemplate.getForObject(url, MFdataByCodeDTO.class);
	}

}

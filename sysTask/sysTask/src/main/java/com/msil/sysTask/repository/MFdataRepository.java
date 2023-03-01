package com.msil.sysTask.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msil.sysTask.entity.MFdata;
//public interface MFdataRepository extends MongoRepository<MFdata, Integer>
public interface MFdataRepository extends JpaRepository<MFdata, Integer>{

	Optional<MFdata> findBySchemeName(String schemeName);

	

	

}

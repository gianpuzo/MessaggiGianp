package com.application.gianp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gianp.repository.GianpRepository;
import com.application.gianp.model.Gianp;

@Service
public class GianpService {
	
	@Autowired
	private GianpRepository gianpRepository;
	
	public List<Gianp> getAllGianps(){
		
		List<Gianp> gianps = new ArrayList<>();
		gianpRepository.findAll().forEach(gianps::add);
		return gianps;
	}
	
	public String getGianpFromNativeQuery(Integer id) {
		return gianpRepository.findGianpByIdnativeQuery(id);
		
	}
	
	public Gianp getGianp(Integer id) {
		return gianpRepository.findOne(id);
		
	}
	
	public void addGianp(Gianp gianp) {

		gianpRepository.save(gianp);
	}
	
	public void deleteGianp(Integer id) {
		
		gianpRepository.delete(id);
	}
	
	public void updateGianp(Integer id, String newMessage) {
		
		Gianp gianp = this.getGianp(id);
		gianp.setMessage(newMessage);
		gianpRepository.save(gianp);
	}
	
	public String testGianp(Integer id) {
		
		return gianpRepository.findGianpByIdnativeQuery(id);
	}
	
	
	public List<Object[]> getAllGianpsFromGenericObject(){
		
		return gianpRepository.findAllToGenericObject();
	}	
	
	

}

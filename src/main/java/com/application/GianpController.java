package com.application;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.gianp.model.Gianp;
import com.application.gianp.service.GianpService;

@Controller
public class GianpController {
	
	private GianpService gianpService;
	
	@Autowired(required=true)
	@Qualifier("gianpService")
	public void setGianpService(GianpService ps){
		this.gianpService = ps;
	}
	
	@RequestMapping(value = "/MessaggiGianp/gianps", method = RequestMethod.GET)
	public String listGianps(Model model) {
		model.addAttribute("gianp", new Gianp());
		Logger logger = LogManager.getLogger("[carica lista]");
		logger.info("get list - start");
		model.addAttribute("listGianps", this.gianpService.getAllGianps());
		logger.info("get list - end");
		return "gianp";
	}
	
	@RequestMapping(value= "/gianp/add", method = RequestMethod.POST)
	public String addGianp(@ModelAttribute("gianp") Gianp p){
		
		Logger logger = LogManager.getLogger("[inserisci messaggio]");
		logger.info("write message - start");
			this.gianpService.addGianp(p);
			logger.info("write message - end");
		return "redirect:/MessaggiGianp/gianps";
		
	}
	
	@RequestMapping("/remove/{idgianp}")
    public String removeGianp(@PathVariable("idgianp") int id){
		Logger logger = LogManager.getLogger("[cancella messaggio]");
		logger.info("delete message - start");
        this.gianpService.deleteGianp(id);
        logger.info("delete message - end");
        return "redirect:/MessaggiGianp/gianps";
    }
 
    @RequestMapping(value ="/edit/{idgianp}", method = RequestMethod.POST)
    public String editGianp(@PathVariable("idgianp") int id,@ModelAttribute("gianp") Gianp pnew, Model model){
    	Logger logger = LogManager.getLogger("[modifica messaggio]");
    	logger.info("update message - start");
    	this.gianpService.updateGianp(id, pnew.getMessage());
    	logger.info("update message - end");
        return "redirect:/MessaggiGianp/gianps";
    }
    
	@RequestMapping(value = "/testGianp/{id}", method = RequestMethod.GET)
	public String testGianp(Model model, @PathVariable("id") int id) {
		model.addAttribute("name", gianpService.getGianpFromNativeQuery(id));

		return "hello";
	}
	
	@RequestMapping(value = "/testGianpAll", method = RequestMethod.GET)
	public String testGianpAll(Model model) {
		List<Object[]> gianps = gianpService.getAllGianpsFromGenericObject();
		String result ="";
		for(Object[] obj : gianps){
			result = result + "{";
			for (Object ob : obj) {
				result= result +String.valueOf(ob)+" ";
			}
			result = result + "} ";
		}
		model.addAttribute("name", result);
		return "hello";
	}
	
	
	
}

package com.nemo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nemo.configuration.CapitalsDispatcher;
import com.nemo.service.CapitalsService;

@Controller
public class CapitalsController {
	
	@RequestMapping("/countries")
	public ModelAndView getCapital(@RequestParam("country") String coun) {
		
		System.out.println("controller....");
		ApplicationContext factory = new AnnotationConfigApplicationContext(CapitalsDispatcher.class);
		
		CapitalsService cs = factory.getBean(CapitalsService.class);
		cs.addCapital("egypt", "Cairo");
		String cap = cs.getCapitalByCountry(coun).toUpperCase();

//		System.out.println(coun);
		ModelAndView mv = new ModelAndView("countries");
		mv.addObject("result", cap);
		mv.addObject("country", coun.toUpperCase());
		
		return mv;
	}

}

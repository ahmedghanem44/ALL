package com.nemo.capitals;

import 	org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CapitalController {
		
	@RequestMapping("/countries")
	public ModelAndView getCapital(@RequestParam("country") String coun) {
		
		CapitalFinderService cf = new CapitalFinderService();
		String cap = cf.findCapital(coun);

		
		ModelAndView mv = new ModelAndView("countries");
		mv.addObject("result", cap);
		mv.addObject("country", coun.toUpperCase());

		return mv;
	}
}

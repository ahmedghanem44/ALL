package java.com.nemo.capitals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CapitalsController {
	
	@RequestMapping("/countries")
	public ModelAndView getCapital(@RequestParam String country) {
		
		CapitalDaoImp cap = new CapitalDaoImp();
		CountryCapitalBean ccb = new CountryCapitalBean();
		ccb.setCountry("Egypt");
		ccb.setCapital("Cairo");
		cap.addCountryCapital(ccb);
		
		String capital = cap.getCapitalByCountry(country.toLowerCase());
		
		ModelAndView mv = new ModelAndView("countries");
		mv.addObject("result", capital.toUpperCase());
		mv.addObject("country", country.toUpperCase());
	
		return mv;
	}
}

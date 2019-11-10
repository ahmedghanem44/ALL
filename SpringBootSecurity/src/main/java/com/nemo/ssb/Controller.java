package com.nemo.ssb;


import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
//	@GetMapping("/home")
//	public String hello(@RequestParam String name) {
//		return "Hello "+ name ;
//	}
	
	@GetMapping("/home")
	public String hello(@RequestParam String name, Principal user) {
		return "Hello "+ user.getName() ;
	}
	
//	@GetMapping("/home")
//	public String hello() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		return "Hello "+ auth.getName() ;
//	}

}

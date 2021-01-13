package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/securityController")
public class LoginController {
	
	@GetMapping("/loginPage")
	public String showLoginPage() {
		
		return "login-page";
	}
	
	@GetMapping("/accesDenied")
	public String accessDenied() {
		
		return "access-denied";
	}
}

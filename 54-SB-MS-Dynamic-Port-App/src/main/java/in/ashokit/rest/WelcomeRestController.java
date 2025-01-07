package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		
		String port = env.getProperty("server.port");
		
		String str= "welcome to the Ashok It !!"+"Server running on this port:!! "+port;
		return str;
		 
	}

}

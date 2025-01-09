package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to Ashok It";
		
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "greeet";
	}
}

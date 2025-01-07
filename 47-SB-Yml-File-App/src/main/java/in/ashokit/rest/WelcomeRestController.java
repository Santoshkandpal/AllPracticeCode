package in.ashokit.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.props.AppProperties;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private AppProperties appProps;
	
	@GetMapping("/welcome")
	public String welcomemessage() {
		Map<String, String> msgs = appProps.getMessages();
		String msgValue = msgs.get("welcomeMsg");
		return msgValue;
	}
	
	@GetMapping("/greet")
	public String greetmessage() {
		Map<String, String> msgs = appProps.getMessages();
		String msgValue = msgs.get("greetMsg");
		return msgValue;
	}

}

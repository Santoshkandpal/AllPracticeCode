package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepository;
import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository customerRepo; 
	
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	@Autowired	
	private AuthenticationManager authMangaer;

	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return "welcome to Ashok It";
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCheck(@RequestBody Customer customer){
		
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPwd());
		
		Authentication authenticate = authMangaer.authenticate(token);	
		
		try {
			if(authenticate.isAuthenticated()) {
				return new ResponseEntity<>("welcome to ashok It", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Invalid Credentials",HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
		
		String encodedPwd = pwdEncoder.encode(customer.getPwd());
		customer.setPwd(encodedPwd);
		customerRepo.save(customer);
		return new ResponseEntity<String>("Customer Registered",HttpStatus.CREATED);
	}

}

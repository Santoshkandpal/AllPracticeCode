package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.FlighService;

@RestController
public class FlightRestController {
	
	@Autowired
	private FlighService flighService;
	
	@GetMapping(value="/flights")
	private String getFlight() {
		
		String invokeUnitedFlightApi = flighService.invokeUnitedFlightApi();
		return invokeUnitedFlightApi;
		
	}

}

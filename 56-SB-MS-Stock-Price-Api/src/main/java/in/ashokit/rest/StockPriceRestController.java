package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.StockPriceResponse;
import in.ashokit.service.StockPriceService;

@RestController
public class StockPriceRestController {
	
	@Autowired
	private StockPriceService service;
	
	@GetMapping("/price/{companyName}")
	public ResponseEntity<StockPriceResponse> getStockPrice(@PathVariable String companyName){
		StockPriceResponse response = service.getStockPrice(companyName);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}

}

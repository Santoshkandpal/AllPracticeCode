package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.StockCalcApiResponse;
import in.ashokit.service.StockCalcService;

@RestController
public class StockCalcRestController {
	
	@Autowired
	private StockCalcService calcService;
	
	@GetMapping("/calc/{companyName}/{quantity}")
	public StockCalcApiResponse getStocksCost(@PathVariable String companyName,@PathVariable Integer quantity) {
		StockCalcApiResponse stockCost = calcService.getStockCost(companyName, quantity);
		return stockCost;
		
	}

}

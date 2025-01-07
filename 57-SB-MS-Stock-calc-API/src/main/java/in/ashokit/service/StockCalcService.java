package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.StockCalcApiResponse;
import in.ashokit.bindings.StockPriceApiResponse;
import in.ashokit.client.StockPriceClient;

@Service
public class StockCalcService {
	
	@Autowired
	private StockPriceClient priceClient;
	
	public StockCalcApiResponse getStockCost(String companyName,Integer quantity) {
		StockCalcApiResponse response = new StockCalcApiResponse();
		
		// Access Stock Price API with company name
		
		StockPriceApiResponse priceApiResponse = priceClient.invokeStockPriceAPI(companyName);
		
		Double companyStockPrice = priceApiResponse.getCompanyStockPrice();
		
		// Calculating total cost based on price & Quantity
		double total = companyStockPrice*quantity;
		
		response.setCompanyName(companyName);
		response.setPortNumber(priceApiResponse.getPortNumber());
		response.setQuantity(quantity);
		response.setTotalCost(total);
		
		
		return response;
		
	}
	
	

}

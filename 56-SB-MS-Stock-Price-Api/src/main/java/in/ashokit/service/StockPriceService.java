package in.ashokit.service;

import in.ashokit.bindings.StockPriceResponse;

public interface StockPriceService {
	
	StockPriceResponse getStockPrice(String companyName);

}

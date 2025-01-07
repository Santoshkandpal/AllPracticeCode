package in.ashokit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ashokit.bindings.StockPriceApiResponse;

@FeignClient(name="STOCK-PRICE-API")
public interface StockPriceClient {
	
	@GetMapping("/price/{companyName}")
	public StockPriceApiResponse invokeStockPriceAPI(@PathVariable String companyName);

}

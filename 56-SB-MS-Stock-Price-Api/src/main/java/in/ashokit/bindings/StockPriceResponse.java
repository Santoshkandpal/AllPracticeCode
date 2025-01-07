package in.ashokit.bindings;

import lombok.Data;

@Data
public class StockPriceResponse {
	
	private String companyName;
	
	private Double companyStockPrice;
	
	private Integer portNumber;

}

package in.ashokit.bindings;

import lombok.Data;

@Data
public class StockPriceApiResponse {
	
	private String CompanyName;
	
	private Double companyStockPrice;
	
	private Integer portNumber;

}

package in.ashokit.bindings;

import lombok.Data;

@Data
public class StockCalcApiResponse {
	private String companyName;

	private Integer portNumber;
	
	private Integer quantity;

	private Double totalCost;

}

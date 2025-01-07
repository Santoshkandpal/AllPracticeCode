package in.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FlighService {

	public String invokeUnitedFlightApi() {

		String apiUrl = "https://catfact.ninja/fact";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> responseEntity = rt.getForEntity(apiUrl, String.class);

		int statusCodeValue = responseEntity.getStatusCodeValue();
		String body = responseEntity.getBody();
		return body;

	}

}

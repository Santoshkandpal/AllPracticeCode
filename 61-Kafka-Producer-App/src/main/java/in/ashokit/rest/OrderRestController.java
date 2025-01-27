package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Order;
import in.ashokit.constants.AppConstants;

@RestController
public class OrderRestController {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	
	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		kafkaTemplate.send(AppConstants.TOPIC,order);
		return "Msg Published to Kafka Topic";
		
	}
}

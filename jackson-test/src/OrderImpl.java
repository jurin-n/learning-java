package src;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OrderImpl implements Order2 {

	@JsonProperty("order-id")
	private int orderId;

	@Override
	public int getOrderId() {
		return this.orderId;
	}

	@Override
	public void setOrderId(int orderId) {
		this.orderId=orderId;
	}

}

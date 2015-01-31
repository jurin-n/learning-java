package src;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Order {
	@JsonProperty("order-id")
	private int orderId;

	public int getOrderId(){
		return this.orderId;
	}

	public void setOrderId(int orderId){
		this.orderId=orderId;
	}
}

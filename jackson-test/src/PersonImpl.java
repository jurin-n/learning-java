package src;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PersonImpl implements Person {
	private String name;
	private Collection<Order2> orders;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@JsonTypeInfo(use=JsonTypeInfo.Id.NONE,defaultImpl=OrderImpl.class)
	public Collection<Order2> getOrders() {
		return orders;
	}

	@JsonTypeInfo(use=JsonTypeInfo.Id.NONE,defaultImpl=OrderImpl.class)
	public void setOrders(Collection<Order2> orders) {
		this.orders = orders;
	}


}

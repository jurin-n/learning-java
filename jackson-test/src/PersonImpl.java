package src;

import java.util.Collection;

public class PersonImpl implements Person {
	private String name;
	//@JsonTypeInfo(use=JsonTypeInfo.Id.NONE,defaultImpl=OrderImpl.class)
	private Collection<Order> orders;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Order> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}


}

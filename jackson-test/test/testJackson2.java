package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import src.Order;
import src.Order2;
import src.Person;
import src.PersonImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

public class testJackson2 {
	@Test
	public void testメンバ名がハイフン区切りのJSONをJavaBeanにでシリアライズする方法() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Order order = mapper.readValue("{\"order-id\":480310}", Order.class);
			System.out.println(order.getOrderId());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testJavaBeanがインターフェイスと実装に分離している場合() {
		String jsonText="{\"name\":\"sunny\",\"age\":20,\"orders\":[{\"order-id\":10000},{\"order-id\":20000}]}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Person person = mapper.readValue(jsonText, PersonImpl.class);
			System.out.println(person.getName());
			Collection<Order2> orders = person.getOrders();
			for(Order2 o:orders){
				System.out.println("o.getOrderId()=" + o.getOrderId());
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}

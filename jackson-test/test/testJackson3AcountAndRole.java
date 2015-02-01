package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;

import src.Acount;
import src.Role;

import com.fasterxml.jackson.databind.ObjectMapper;

public class testJackson3AcountAndRole {

	@Test
	public void test() {
		String jsonText="{\"userId\":\"12345\",\"userName\":\"山田太郎\",\"roles\":[{\"rowNo\":\"01\",\"roleNo\":\"30\"},{\"rowNo\":\"02\",\"roleNo\":\"80\"}]}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Acount account = mapper.readValue(jsonText, Acount.class);
			System.out.println(account.getUserId());
			System.out.println(account.getUserName());

			Collection<Role> roles = account.getRoles();

			for(Role role:roles){
				System.out.println("role=" + role);
				System.out.println("role.getRowNo()=" + role.getRowNo());
				System.out.println("role.getRoleNo()=" + role.getRoleNo());
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}

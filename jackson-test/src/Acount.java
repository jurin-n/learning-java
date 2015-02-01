package src;

import java.util.Collection;

public class Acount {
	private int userId;
	private String userName;
	private Collection<Role> roles;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Role> getRoles() {
		return this.roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}

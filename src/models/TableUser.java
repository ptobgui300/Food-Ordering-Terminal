package models;

public class TableUser {
	String loginId, password;
	int id;
	
	
	static int count = 1;
	
	
	public TableUser( String loginId, String password) {
		this.id = count++;
		this.loginId = loginId;
		this.password = password;
	}
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	
	
}
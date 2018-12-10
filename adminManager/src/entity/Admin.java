package entity;

public class Admin {
	private int id;
	private String uname;
	private String password;
	private String realname;
	
	public Admin(){}
	public Admin(String uname,String password,String realname){
		this.uname = uname;
		this.password = password;
		this.realname = realname;
	}
	public Admin(int id, String uname, String password, String realname) {
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.realname = realname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}

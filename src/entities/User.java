package entities;

public class User {

	private Integer userId;
	private String name;
	private String email;
	private UserAccount account;
	private Boolean adminAuthority;

	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserAccount getAccount() {
		return account;
	}
	public void setAccount(UserAccount account) {
		this.account = account;
	}
	public Boolean getAdminAuthority() {
		return adminAuthority;
	}
	public void setAdminAuthority(Boolean adminAuthority) {
		this.adminAuthority = adminAuthority;
	}	 
	
	public Boolean verify(String enteredPswd) {
		if (this.account.getUserName().equals(enteredPswd)) {
			return true;
		}
		return false;
	}
}

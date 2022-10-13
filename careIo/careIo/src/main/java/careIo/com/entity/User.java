package careIo.com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name="user_details")
public class User {

	@Id
	@GeneratedValue
	public long loginId;
	public long userId;
	public int isactive;
	public String passwords;
	
	//minimum of two character in the name //@past annotation for the dates if need to be checked for the past or future 
	@Size(min=2,message="Name Should be atleast 2 character long.")
	public String username;
	
	public User(long loginId, long userId, int isactive, String passwords, String username, String role) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.isactive = isactive;
		this.passwords = passwords;
		this.username = username;
		this.role = role;
	}
	public String role;
	
	
	
	public long getLoginId() {
		return loginId;
	}
	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getIsactive() {
		return isactive;
	}
	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	





	
}

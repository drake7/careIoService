package careIOv2.org.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
//pojo class
@Entity(name="careusers")
public class User {

	protected User() {
		
	}
	@Id
	@GeneratedValue
	public int loginId;
	//not mandatory to map names if the names of the properties inside bean and the table is same
	@Column(name="userId")
	public int userId;
	
	@Column(name="is_active")
	public int isactive;
	
	@Column(name="passwords")
	public String passwords;
	
	//minimum of two character in the name //@past annotation for the dates if need to be checked for the past or future 
	@Size(min=2,message="Name Should be atleast 2 character long.")
	@Column(name="username")
	public String username;
	
	public User(int loginId, int userId, int isactive, String passwords, String username, String role) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.isactive = isactive;
		this.passwords = passwords;
		this.username = username;
		this.role = role;
	}
	public String role;
	
	
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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

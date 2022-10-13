package careIOv2.org.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import careIOv2.org.entity.User;


@Component
public class UserDaoService {
	
	
	private static List<User> users=new ArrayList<>(); 
	private static int userCount=0;
	static {
		
		users.add(new User(++userCount,2,1,"password","jim","USER"));
		users.add(new User(++userCount,3,1,"password","micheal","USER"));
		users.add(new User(++userCount,3,1,"password","dwight","USER"));
	}
	
	
//**********************************************************************************//	
	//find the details of the user
	public List<User> findAll(){
		
		return users;
	}
	//find using the id of the user
	public User findById(int id){
		Predicate<? super User> predicate = user -> user.getLoginId()==(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	//find using the name of the user
	public User findByName(String name){
		Predicate<? super User> predicate = user -> user.getUsername().equals(name);
		return users.stream().filter(predicate).findFirst().get();
		
	}
//*************************************************************************************//
	//creating the users
	public User createNewUser(User user) {
	user.setLoginId(++userCount);
	users.add(user);
	return user;
	}
	
//**********************************************************************************//
	public void deleteById(int id){
		Predicate<? super User> predicate = user -> user.getLoginId()==(id);
		users.removeIf(predicate);
		
	}
	
	
	
	}

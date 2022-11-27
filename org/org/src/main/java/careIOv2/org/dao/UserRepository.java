package careIOv2.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import careIOv2.org.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
	

}

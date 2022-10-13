package careIOv2.org.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String sqlUserInsert="insert into careio.careuser\r\n" + 
			"(userId,isActive,password,badlogin,username,role)\r\n" + 
			"values \r\n" + 
			"(1,true,'password',0,'user','user');";
	public void insertUser()
	{
		springJdbcTemplate.update(sqlUserInsert);
	}
}

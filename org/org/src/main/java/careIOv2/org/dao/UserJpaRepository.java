//package careIOv2.org.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import careIOv2.org.entity.User;
///*
//@Repository
//@Transactional
//public class UserJpaRepository {
//
//	
//	//@Autowired can work too but better if we use
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public void insert(User user)
//	{
//		entityManager.merge(user);
//	}
//	
//	
//	
//	public User findByUserId(long loginId)
//	{
//		return entityManager.find(User.class, loginId);
//	}
//}
///
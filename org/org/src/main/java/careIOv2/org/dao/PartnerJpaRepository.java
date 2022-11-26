package careIOv2.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import careIOv2.org.entity.Partner;

@Repository
@Transactional
public class PartnerJpaRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Partner partner)
	{
		entityManager.merge(partner);
	}
	public Partner findByPartnerId(long partnerId)
	{
		return entityManager.find(Partner.class, partnerId );
	}
}

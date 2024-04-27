package trojanHousing.backend.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trojanHousing.backend.entity.Property;
import trojanHousing.backend.entity.SavedListings;

@Repository
public class SavedListingsRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void addToSavedListings(SavedListings newSavedListing) 
	{
		if(newSavedListing != null) 
		{
			em.persist(newSavedListing);
		}
		
		
	}
	
	public List<Property> getSavedListings(String userId) 
	{
		
		List<Property> savedProperties = em.createQuery("SELECT s.property FROM SavedListings s WHERE s.user.userId = :userId", Property.class)
		.setParameter("userId", userId).getResultList();
		return savedProperties;	
	}	
	

	
}

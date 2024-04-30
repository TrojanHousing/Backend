package trojanHousing.backend.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trojanHousing.backend.entity.Property;
import trojanHousing.backend.entity.SavedListings;

@Repository
public class SavedListingsRepository {
	
	@PersistenceContext
    EntityManager em;
	 
	@Transactional 
    public void addToSavedListings(int userId, int propertyId) {
        SavedListings newSavedListing = new SavedListings(userId, propertyId);
        em.persist(newSavedListing);
        System.out.println("We added a property to the saved listings with user ID: " + userId + " and property ID: " + propertyId);
    }
	
	public List<Property> getSavedListings(int userId) {
	    String queryStr = "SELECT p FROM Property p WHERE p.propertyID IN " +
	                      "(SELECT s.propertyId FROM SavedListings s WHERE s.userId = :userId)";
	    List<Property> savedProperties = em.createQuery(queryStr, Property.class)
	                                       .setParameter("userId", userId)
	                                       .getResultList();
	    return savedProperties;
	}
	

	
}
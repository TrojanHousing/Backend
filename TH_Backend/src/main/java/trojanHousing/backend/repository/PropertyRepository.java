package trojanHousing.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trojanHousing.backend.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {
    // You can add custom query methods here if needed
}

//@Repository
//public class PropertyRepository { 
//	@PersistenceContext
//	EntityManager em;
//	
//	public List<Property> getProperties() {
//		System.out.println("Getting props: ");
//		
//		@SuppressWarnings("unchecked")
//		List<Property> properties = em.createQuery("SELECT p FROM Property p", Property.class).getResultList();
//		if (properties.isEmpty()) {
//			return null;
//		}
//		else {
//			System.out.println("Num: " + properties.size()); 
//			return properties;
//		}
//	}
//}

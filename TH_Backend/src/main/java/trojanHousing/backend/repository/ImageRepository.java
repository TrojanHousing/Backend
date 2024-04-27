package trojanHousing.backend.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import trojanHousing.backend.entity.Image;
import trojanHousing.backend.entity.Property;

@Repository
public class ImageRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Image> getImages(int pid) {
		@SuppressWarnings("unchecked")
		List<Image> images = em.createQuery("SELECT c FROM Image c WHERE c.property=:pid")
				.setParameter("pid", em.getReference(Property.class, pid))
				.getResultList();
		if (images.isEmpty()) {
			return null;
		}
		else {
			return images;
		}
	}
}

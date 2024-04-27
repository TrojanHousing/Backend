package trojanHousing.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import trojanHousing.backend.entity.Image;
import trojanHousing.backend.entity.User;

@Repository
public class ImageRepository {
	
	@Autowired
	EntityManager em;
	
	public List<Image> getImages(int pid) {
		@SuppressWarnings("unchecked")
		List<Image> images = em.createQuery("SELECT c FROM Image WHERE c.PropertyID=pid")
				.setParameter("pid", pid)
				.getResultList();
		if (images.isEmpty()) {
			return null;
		}
		else {
			return images;
		}
	}
}

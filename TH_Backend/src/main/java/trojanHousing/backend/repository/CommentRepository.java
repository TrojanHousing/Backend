package trojanHousing.backend.repository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import trojanHousing.backend.entity.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
	
	
	@Autowired
	EntityManager em;
	
	public List<Comment> getByProperty(int propertyID) {
		@SuppressWarnings("unchecked")
		List<Comment> comments = em.createQuery("SELECT c FROM Comment c WHERE c.property=:prop")
					.setParameter("prop", propertyID)
					.getResultList();
		return comments;
	}
	public List<Comment> getByUser(int userID) {
		@SuppressWarnings("unchecked")
		List<Comment> comments = em.createQuery("SELECT c FROM Comment c WHERE c.user=:userID")
					.setParameter("userID", userID)
					.getResultList();
		return comments;
	}
}

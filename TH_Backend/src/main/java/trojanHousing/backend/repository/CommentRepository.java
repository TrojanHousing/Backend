package trojanHousing.backend.repository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import trojanHousing.backend.entity.Comment;
import trojanHousing.backend.entity.User;
import trojanHousing.backend.entity.Property;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
	
	
	@PersistenceContext
	EntityManager em;
	
	public List<Comment> getByProperty(int propertyID) {
		@SuppressWarnings("unchecked")
		List<Comment> comments = em.createQuery("SELECT c FROM Comment c WHERE c.property=:prop")
					.setParameter("prop", em.getReference(Property.class, propertyID))
					.getResultList();
		return comments;
	}
	public List<Comment> getByUser(int userID) {
		@SuppressWarnings("unchecked")
		List<Comment> comments = em.createQuery("SELECT c FROM Comment c WHERE c.user=:userID")
					.setParameter("userID", em.getReference(User.class, userID))
					.getResultList();
		return comments;
	}
	@Transactional
	public void addComment(int propertyID, int userID, String text, int rating) {
		User user = em.getReference(User.class, userID);
		Property property = em.getReference(Property.class, propertyID);
		Comment comment = new Comment();
		comment.setProperty(property);
		comment.setUser(user);
		comment.setText(text);
		comment.setRating(rating);
		em.persist(comment);
	}
}

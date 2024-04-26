package trojanHousing.backend.repository;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import trojanHousing.backend.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@PersistenceContext
	EntityManager em;

	public User getUserByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<User> user = em.createQuery("SELECT c FROM User c WHERE c.EmailAddress=:email")
					.setParameter("email", email)
					.getResultList();
		if (user.isEmpty()) {
			return null;
		} else {
			return user.get(0);
		}
	}

	public int addUser(User user) {
		em.persist(user);
		em.flush();
		return user.getUserId();
	}
}
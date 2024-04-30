package trojanHousing.backend.repository;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import trojanHousing.backend.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	EntityManager em;

	public User findUserById(int userId) 
	{
		return em.find(User.class, userId);
	}
	
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
	@Transactional
	public int addUser(User user) {
		em.persist(user);
		em.flush();
		return user.getUserId();
	}
}
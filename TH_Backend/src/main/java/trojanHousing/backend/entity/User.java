package trojanHousing.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	
	@Column(length = 40, nullable = false)
	private String EmailAddress;
	
	@Column(length = 40, nullable = false)
	private String Password;

	public User() {
		super();
	}

	public User(int UserId, String EmailAddress, String Password) {
		super();
		this.UserId = UserId;
		this.EmailAddress = EmailAddress;
		this.Password = Password;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

}

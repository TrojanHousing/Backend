package trojanHousing.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SavedListings")
public class SavedListings
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saverListingId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PropertyID")
	private Property property;
	
	public SavedListings(User user, Property property) 
	{
		this.user = user;
		this.property = property;
	}
	
	
	public int getSavedListingId() 
	{
		return this.saverListingId;
	}
	public void setSavedListingId(int savedListingId) 
	{
		this.saverListingId = savedListingId;
	}
	public User getUser()
	{
		return this.user;
	}
	public void setUser(User user) 
	{
	    this.user = user;
	}

	public Property getProperty() 
	{
		return property;
	}

	public void setProperty(Property property) 
	{
	    this.property = property;
	}
	
}
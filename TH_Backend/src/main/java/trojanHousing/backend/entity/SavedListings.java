package trojanHousing.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SavedListings")
public class SavedListings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SavedListingId")
    private int savedListingId;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "PropertyID")
    private int propertyId;

    // Default constructor
    public SavedListings() {}

    // Getters and setters
    public int getSavedListingId() {
        return savedListingId;
    }

    public void setSavedListingId(int savedListingId) {
        this.savedListingId = savedListingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    // Constructor with parameters
    public SavedListings(int userId, int propertyId) {
        this.userId = userId;
        this.propertyId = propertyId;
    }
}
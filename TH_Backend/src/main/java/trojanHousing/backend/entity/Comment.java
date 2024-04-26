package trojanHousing.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PropertyID")  // Assuming the foreign key should not be nullable as typical for IDs
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")  // Assuming the foreign key should not be nullable as typical for IDs
    private User user;

    @Column(length = 40, nullable = false)
    private String text;

    // Getters and setters
    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

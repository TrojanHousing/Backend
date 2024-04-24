package trojanHousing.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

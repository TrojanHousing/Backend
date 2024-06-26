package trojanHousing.backend.controller;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import trojanHousing.backend.entity.Property;
import trojanHousing.backend.entity.Comment;
import trojanHousing.backend.entity.Image;
import trojanHousing.backend.repository.CommentRepository;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class CommentController {
	@Autowired
	CommentRepository commentRepo;
	
	@CrossOrigin
	@RequestMapping(value = "/getCommentsByPropertyID", method = RequestMethod.POST)
	@ResponseBody
	public String getCommentsByPropertyID(@RequestParam("propertyID") int propertyID,
		HttpServletResponse response)
		throws IOException {
		try {
			List<Comment> comments = commentRepo.getByProperty(propertyID);
			if (comments.size() == 0) {
				return "[]";
			}
			List<String> commentText = new ArrayList<>();
			List<Integer> commentRatings = new ArrayList<>();
			List<Property> commentProperties = new ArrayList<>();
			for (Comment comment: comments) {
				commentText.add(comment.getText());
				commentRatings.add(comment.getRating());
				commentProperties.add(comment.getProperty());			
			}
			// manually make json string
			// {"name":"John","age":30,"email":"john@example.com"}
			String commentsJson = "";
			if (comments.size() != 1) {
				commentsJson += "[";
			}
			for (int i = 0; i < comments.size(); i++) {
				commentsJson += "{\"text\":\"" + commentText.get(i) + "\",\"rating\":" + commentRatings.get(i)
				+ ",\"propertyID\":" + commentProperties.get(i).getPropertyID()
				+ ",\"address\":\"" + commentProperties.get(i).getAddress() + "\"}";
				if ((i + 1) != comments.size()) { // not last thing
					commentsJson += ",";
				}
				else {
					if (comments.size() != 1) {
						commentsJson += "]";
					}
				}
			}
//			Gson gson = new Gson();
			response.setStatus(HttpServletResponse.SC_OK);
			return commentsJson;
//			Type listType = new TypeToken<List<Comment>>() {}.getType();
//			return gson.toJson(comments,listType);
		} catch (Exception e) {
			System.out.println("Error occured at CommentsController : " + e.getMessage());
			response.setStatus(404);
			return ("Error :(");
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCommentsByUser", method = RequestMethod.POST)
	@ResponseBody
	public String getCommentsByUser(@RequestParam("userID") int userID,
		HttpServletResponse response)
		throws IOException {
		try {
			List<Comment> comments = commentRepo.getByUser(userID);
			if (comments.size() == 0) {
				return "[]";
			}
			List<String> commentText = new ArrayList<>();
			List<Integer> commentRatings = new ArrayList<>();
			List<Property> commentProperties = new ArrayList<>();
			for (Comment comment: comments) {
				commentText.add(comment.getText());
				commentRatings.add(comment.getRating());
				commentProperties.add(comment.getProperty());
			}
			// manually make json string
			String commentsJson = "";
			if (comments.size() != 1) {
				commentsJson += "[";
			}
			for (int i = 0; i < comments.size(); i++) {
				commentsJson += "{\"text\":\"" + commentText.get(i) + "\",\"rating\":" + commentRatings.get(i)
				+ ",\"propertyID\":" + commentProperties.get(i).getPropertyID()
				+ ",\"address\":\"" + commentProperties.get(i).getAddress() + "\"}";
				if ((i + 1) != comments.size()) { // not last thing
					commentsJson += ",";
				}
				else {
					if (comments.size() != 1) {
						commentsJson += "]";
					}
				}
			}
			response.setStatus(HttpServletResponse.SC_OK);
			return commentsJson;
		} catch (Exception e) {
			System.out.println("Error occured at CommentsController : " + e.getMessage());
			response.setStatus(404);
			return ("Error :(");
		}
	}
	@CrossOrigin
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addComment(@RequestParam("propertyID") int propertyID, @RequestParam("userID") int userID, 
		@RequestParam("text") String text, @RequestParam("rating") int rating)
		throws IOException {
		try {
			commentRepo.addComment(propertyID, userID, text, rating);
			return ResponseEntity.ok("Comment added");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error adding comment");
		}
	}
	
}

package trojanHousing.backend.controller;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import trojanHousing.backend.entity.Comment;
import trojanHousing.backend.repository.CommentRepository;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class CommentController {
	@Autowired
	CommentRepository commentRepo;
	
	@RequestMapping(value = "/getCommentsByPropertyID", method = RequestMethod.POST)
	@ResponseBody
	public String getCommentsByPropertyID(@RequestParam("PropertyID") int propertyID,
		HttpServletResponse response)
		throws IOException {
		try {
			List<Comment> comments = commentRepo.getByProperty(propertyID);
			Gson gson = new Gson();
			return gson.toJson(comments);
		} catch (Exception e) {
			System.out.println("Error occured at CommentsController : " + e.getMessage());
			response.setStatus(404);
			return ("Error :(");
		}
	}
	@RequestMapping(value = "/getCommentsByUser", method = RequestMethod.POST)
	@ResponseBody
	public String getCommentsByUser(@RequestParam("PropertyID") int userID,
		HttpServletResponse response)
		throws IOException {
		try {
			List<Comment> comments = commentRepo.getByUser(userID);
			Gson gson = new Gson();
			return gson.toJson(comments);
		} catch (Exception e) {
			System.out.println("Error occured at CommentsController : " + e.getMessage());
			response.setStatus(404);
			return ("Error :(");
		}
	}
}

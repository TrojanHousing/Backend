package trojanHousing.backend.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import trojanHousing.backend.entity.User;
import trojanHousing.backend.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller 
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@CrossOrigin
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public int login(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpServletResponse response, HttpSession session)
			throws IOException {
		try {
			User user = userRepo.getUserByEmail(email);
			if (user == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return -1;
			} else {
				if (user.getPassword().equals(password)) {
					session.setAttribute("userId", user.getUserId());
					response.setStatus(HttpServletResponse.SC_OK);
					return (user.getUserId());
				} else {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
					return (-2);
				}
			}
		} catch (Exception e) {
			System.out.println("Error occured at UsersController : " + e.getMessage());
			response.setStatus(404);
			return (0);
		}
	}
	@CrossOrigin
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	@ResponseBody
	public int register(@RequestParam("email") String email, 
			@RequestParam("password") String password, HttpServletResponse response, HttpSession session) 
			throws IOException {
		try {
			if (userRepo.getUserByEmail(email) == null) {
				User user = new User();
				user.setEmailAddress(email);
				user.setPassword(password);
				int userID = userRepo.addUser(user);
				session.setAttribute("userId", userID);
				response.setStatus(HttpServletResponse.SC_OK);
				return (user.getUserId());
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return (-1);
			}
		} catch (Exception e) {
			System.out.println("Error occured at UserController : " + e.getMessage());
			response.setStatus(404);
			return (0);
		}
	}
}
package trojanHousing.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import trojanHousing.backend.entity.User;
import trojanHousing.backend.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@Controller
public class ImageController {
	/*getImage(PropertyID) this gets called from our Listing class and returns an image URL.*/
	/*
	@Autowired
	ImageRepository imageRepository;
	
	@RequestMapping(value = "/getImage", method = RequestMethod.POST)
	@RequestBody
	public String getImages(@RequestParam("property_id") int pid) {
		return imageRepository.getImage(pid);
	}
	*/
	
	/* @Controller 
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpServletResponse response, HttpSession session)
			throws IOException {
		try {
		*/
}

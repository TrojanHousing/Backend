package trojanHousing.backend.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import trojanHousing.backend.entity.Property;
import trojanHousing.backend.entity.SavedListings;
import trojanHousing.backend.entity.User;
import trojanHousing.backend.repository.PropertyRepository;
import trojanHousing.backend.repository.SavedListingsRepository;
import trojanHousing.backend.repository.UserRepository;
import java.util.List; 

@Controller
public class SavedListingsController {
	
	@Autowired
	SavedListingsRepository savedListingsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyRepository propertyRepository;
	@PersistenceContext
	EntityManager em;
	
	
	//Have this as returning a string for now
	@RequestMapping(value = "/addListing", method = RequestMethod.POST)
	public String addToSaveListing(@RequestParam("userID") int userID, 
			@RequestParam("propertyID") int propertyID) throws IOException
	{
		
		 User user = userRepository.findUserById(userID);
	     Property property = em.getReference(Property.class, propertyID);

	     if (user != null && property != null) {
	          SavedListings newSavedListing = new SavedListings(user, property);
	          savedListingsRepository.addToSavedListings(newSavedListing);
	          return "redirect:/someSuccessUrl"; // Redirect or return a success view
	     } 
	     else {
	          return "redirect:/errorUrl"; // Redirect or return an error view
	        
	     }
	}
	
	@RequestMapping(value = "/getSavedListings")
	public String getSavedListings(@RequestParam("userID") int userID) 
	{
		List<Property> savedListings = savedListingsRepository.getSavedListings(userID);
				
		
		Gson gson = new Gson();
		return gson.toJson(savedListings);
		
		
	}
	
	
	

	

}

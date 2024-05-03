package trojanHousing.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

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
	@CrossOrigin
	@RequestMapping(value = "/addListing", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addToSaveListing(@RequestParam("userID") int userID, 
			@RequestParam("propertyID") int propertyID) throws IOException
	{
		System.out.println("We made it into the addListing. Our userID is: " + userID + " and out propertyID is: " + propertyID);
		
	     if (userID > 0  && propertyID > 0) {
	          savedListingsRepository.addToSavedListings(userID, propertyID);
	          return ResponseEntity.ok("Listing successfully addded!"); // Redirect or return a success view
	     } 
	     else {
	          return ResponseEntity.badRequest().body("Error adding listing!"); // Redirect or return an error view
	        
	     }
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSavedListings")
	@ResponseBody
	public ResponseEntity<?> getSavedListings(@RequestParam("userID") int userID) {
		System.out.println("We made it into the getSavedListings. Our userID is: " + userID);
        List<Property> savedListings = savedListingsRepository.getSavedListings(userID);
        return ResponseEntity.ok(savedListings); // The list will be automatically converted to JSON
    }
	
	
	

	

}
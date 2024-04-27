package trojanHousing.backend.controller;

import trojanHousing.backend.entity.Property;
import trojanHousing.backend.repository.*;

import org.springframework.stereotype.Controller;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//@Controller
//public class PropertyController {
	
	/* searchListingsByFilter(Filter filter): This will use the applied filters within the Filter   
	 * object input parameter to return a list of all properties that match the applied filters. This will also call the Image class to get Image URLs.
	 */
	
	/* getSavedListings(int uid): This will take an integer representing the User ID and call 
	 * getSavedListings(uid) in the ListingReposity class, returning a list of Listing objects which have been saved by the user.
	 */
	/*
	@Autowired
	PropertyRepository propertyRepository;
	
	@RequestMapping(value = "/getSavedProperties", method = RequestMethod.GET)
	public List<Property> getSavedProperties(@RequestParam("user_id") int uid) {
		return propertyRepository.getSavedProperties(uid);
	}
	*/
	
	/* addSavedListing(int uid, int pid): This will take a User ID and Property ID as its parameters and call 
	 * addSavedListing() in the JDBC Connector class, returning -1 if it was unsuccessful or 0 if it was.
	 */
	/*
	@RequestMapping(value = "/addSavedProperty", method = RequestMethod.GET)
	public int addSavedListing(@RequestParam("user_id") int uid, @RequestParam("property_id") int pid) {
		return propertyRepository.addSavedProperty(uid, pid);
	}
	*/
//}

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    // Get all properties
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/properties/search")
    public ResponseEntity<List<Property>> searchProperties(@RequestParam Map<String, String> searchParams) {
        PropertySpecificationBuilder builder = new PropertySpecificationBuilder();
        searchParams.forEach((key, value) -> {
            builder.with(new SearchCriteria(key, value));
        });

        Specification<Property> spec = builder.build();
        List<Property> properties = propertyRepository.findAll(spec);
        return ResponseEntity.ok(properties);
    }
}








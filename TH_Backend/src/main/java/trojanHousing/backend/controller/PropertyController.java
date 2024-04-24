package trojanHousing.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PropertyController {
	/* getSavedListings(int uid): This will take an integer representing the User ID and call 
	 * getSavedListings(uid) in the ListingReposity class, returning a list of Listing objects which have been saved by the user.
	 */
	@RequestMapping(value = "/editfooditem", method = RequestMethod.POST)
	public List<Property> getSavedProperties(@RequestParam("user_id") int uid) {
		
	}
}

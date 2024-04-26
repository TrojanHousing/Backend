package trojanHousing.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ImageController {
	/*getImage(PropertyID) this gets called from our Listing class and returns an image URL.*/
	
	@Autowired
	ImageRepository imageRepository;
	
	@RequestMapping(value = "/getImage", method = RequestMethod.GET)
	public String getImage(@RequestParam("property_id") int pid) {
		return imageRepository.getImage(pid);
	}
	
}

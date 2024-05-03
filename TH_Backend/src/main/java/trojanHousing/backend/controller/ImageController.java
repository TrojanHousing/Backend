package trojanHousing.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import trojanHousing.backend.entity.Image;
import trojanHousing.backend.repository.ImageRepository;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImageController {
	/*getImage(PropertyID) this gets called from our Listing class and returns an image URL.*/
	
	@Autowired
	ImageRepository imageRepo;
	
	@CrossOrigin
	@RequestMapping(value = "/getImage", method = RequestMethod.POST)
	@ResponseBody
	public String getImages(@RequestParam("property_id") int pid) {
		List<Image> images = imageRepo.getImages(pid);
		if (images.size() == 0) {
			return "";
		}
		List<String> urls = new ArrayList<>();
		for (Image image: images) {
			urls.add(image.getImageURL());
		}
		
        Gson gson = new Gson();
        String jsonString = gson.toJson(urls);
        return jsonString;
	}
}


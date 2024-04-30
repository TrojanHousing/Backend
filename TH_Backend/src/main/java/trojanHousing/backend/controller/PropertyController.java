package trojanHousing.backend.controller;

import trojanHousing.backend.entity.Image;
import trojanHousing.backend.entity.Property;
import trojanHousing.backend.repository.*;

import org.springframework.stereotype.Controller;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true") // Specify the exact origins
@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;
//
//    // Get all properties
//    @GetMapping
//    public ResponseEntity<List<Property>> getAllProperties() {
//        List<Property> properties = propertyRepository.findAll();
//        return ResponseEntity.ok(properties);
//    }
    @RequestMapping(value = "/filterProperties", method = RequestMethod.POST)
	@ResponseBody
    public List<Property> searchProperties(@RequestBody String searchParams) {
    	System.out.println("Filtering properties"); 
        PropertySpecificationBuilder builder = new PropertySpecificationBuilder();
        Gson gson = new Gson();        
        Type listType = new TypeToken<List<SearchCriteria>>(){}.getType();
        List<SearchCriteria> criteriaList = gson.fromJson(searchParams, listType);        
        
        for (SearchCriteria criteria : criteriaList) {
        	System.out.println(criteria.filterKey); 
        	builder.with(criteria.filterKey, criteria.value);
        }
        
        List<Property> filteredProperties = propertyRepository.findAll(builder.build()); 
        
       return filteredProperties; 
    }

}








package trojanHousing.backend.repository;

import java.util.ArrayList;
import java.util.List;

import trojanHousing.backend.entity.Property;

import org.springframework.data.jpa.domain.Specification;

public class PropertySpecificationBuilder {

    private final List<SearchCriteria> params;

    public PropertySpecificationBuilder(){
        this.params = new ArrayList<>();
    }

    public final PropertySpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, value));
        return this;
    }

    public final PropertySpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Property> build(){
        if(params.size() == 0){
            return null;
        }

        Specification<Property> result = new PropertySpecification(params.get(0));
        for (int idx = 1; idx < params.size(); idx++){
            SearchCriteria criteria = params.get(idx);
            result =  SearchOperation.getDataOption(criteria
                     .dataOption) == SearchOperation.ALL
                     ? Specification.where(result).and(new    
                       PropertySpecification(criteria))
                     : Specification.where(result).or(
                       new PropertySpecification(criteria));
        }
        return result;
    }
}

package trojanHousing.backend.repository;

import trojanHousing.backend.entity.Property;

import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PropertySpecification implements Specification<Property> {
	private static final long serialVersionUID = 1L;
	private final SearchCriteria searchCriteria;
	
	public PropertySpecification(final SearchCriteria searchCriteria){
		super();
		this.searchCriteria = searchCriteria;
	}
	
	@Override
	public Predicate toPredicate(Root<Property> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		String strToSearch = searchCriteria.value.toString().toLowerCase();
		return cb.like(cb.lower(root.get(searchCriteria.filterKey)), "%" + strToSearch + "%");
	}
}

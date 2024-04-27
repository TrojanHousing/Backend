package trojanHousing.backend.repository;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SearchCriteria {

    String filterKey;
    Object value;
    String dataOption;

    public SearchCriteria(String filterKey, Object value) {
        super();
        this.filterKey = filterKey;
        this.value = value;
        this.dataOption = "ALL";
    }
}

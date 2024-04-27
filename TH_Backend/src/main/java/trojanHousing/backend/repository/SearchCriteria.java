package trojanHousing.backend.repository;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SearchCriteria {

    public String filterKey;
    public Object value;
    public String dataOption;

    public SearchCriteria(String filterKey, Object value) {
        super();
        this.filterKey = filterKey;
        this.value = value;
        this.dataOption = "ALL";
    }
}

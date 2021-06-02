package vn.vnpay.persistenjpa.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieSearch extends ObjectSearch {

    @JsonProperty("year_release")
    private Integer year;
}

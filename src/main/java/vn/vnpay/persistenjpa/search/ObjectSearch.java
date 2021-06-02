package vn.vnpay.persistenjpa.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public abstract class ObjectSearch {

    @JsonProperty("keyword")
    private String keyword;

    @JsonProperty("status")
    private String status;

    @JsonProperty("from_date")
    private String fromDate;

    @JsonProperty("to_date")
    private String toDate;
}

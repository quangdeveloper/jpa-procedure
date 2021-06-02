package vn.vnpay.persistenjpa.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserSearch extends ObjectSearch{

    @JsonProperty("role_id")
    private Long roleId;
}

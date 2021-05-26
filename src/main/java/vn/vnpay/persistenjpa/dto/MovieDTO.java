package vn.vnpay.persistenjpa.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private Long id;
    private String name;
    private  Integer releaseYear;
    private String language;
}

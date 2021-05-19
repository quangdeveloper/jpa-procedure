package vn.vnpay.persistenjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MOVIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @Column(name = "N_ID")
    private Long id;

    @Column(name = "S_NAME")
    private String name;

    @Column(name = "N_RELEASE_YEAR")
    private Integer releaseYear;

    @Column(name = "S_LANGUAGE")
    private String language;

}

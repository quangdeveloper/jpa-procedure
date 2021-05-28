package vn.vnpay.persistenjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "N_ID")
    private Long id;

    @Column(name = "S_USER_NAME")
    private String username;

    @Column(name = "S_PASSWORD")
    private String password;

    @Column(name = "S_FULL_NAME")
    private String fullName;

    @Column(name = "S_EMAIL")
    private String email;

    @Column(name = "N_ROLE_ID")
    private Long roleId;


    @Column(name = "N_STATUS")
    private Integer status;

}

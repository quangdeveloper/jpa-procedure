package vn.vnpay.persistenjpa.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private  String password;
    private String fullName;
    private String email;
    private Integer roleId;
    private Integer status;
}

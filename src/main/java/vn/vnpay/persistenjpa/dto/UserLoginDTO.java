package vn.vnpay.persistenjpa.dto;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String username;
    private String password;
    private String token;
    private Long roleId;
}

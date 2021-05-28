package vn.vnpay.persistenjpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private  String password;
    private String fullName;
    private String email;
    private Long roleId;
    private Integer status;
    private String token;
}

package vn.vnpay.persistenjpa.validate;

import com.google.common.base.Strings;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.enums.ActionEnum;

import java.util.HashMap;
import java.util.Map;

public class UserValidate {

    private static final String ID = "ID";
    private static final String USER_NAME = "USER_NAME";
    private static final String PASSWORD = "PASSWORD";
    private static final String FULL_NAME = "FULL_NAME";
    private static final String EMAIL = "EMAIL";


    public static Map<String, String> validateUser(UserDTO userDTO, ActionEnum actionEnum){

        Map<String, String> errorMap = new HashMap<>();

        if (Strings.isNullOrEmpty(userDTO.getUsername())){
            errorMap.put(USER_NAME, "Vui lòng nhập tài khoản");
        }else if (Validator.checkLength(userDTO.getUsername(), 3, 100)){
            errorMap.put(USER_NAME, "Tài khoản không hợp lệ");
        }

        if (Strings.isNullOrEmpty(userDTO.getFullName())){
            errorMap.put(FULL_NAME, "Vui lòng nhập họ và tên");
        }else if (Validator.checkLength(userDTO.getFullName(), 3, 100)){
            errorMap.put(FULL_NAME, "Họ và tên không hợp lệ");
        }

        if (Strings.isNullOrEmpty(userDTO.getEmail())){
            errorMap.put(EMAIL, "Vui lòng nhập email");
        }else if (!Validator.checkEmail(userDTO.getEmail())){
            errorMap.put(EMAIL, "Email không hợp lệ");
        }

        switch (actionEnum){
            case ADD:
                if (Strings.isNullOrEmpty(userDTO.getPassword())){
                    errorMap.put(PASSWORD, "Vui lòng nhập mật khẩu");
                }else if (Validator.checkLength(userDTO.getPassword(), 3, 100)){
                    errorMap.put(PASSWORD, "Mật khẩu không hợp lệ");
                }
                break;
            case UPDATE:
                if (Validator.checkID(userDTO.getId())){
                    errorMap.put(ID, "Vui lòng nhập mã");
                }
                break;
            case DELETE:
                if (Validator.checkID(userDTO.getId())){
                    errorMap.put(ID, "Vui lòng nhập mã");
                }
                break;
        }

        return errorMap;
    }
}

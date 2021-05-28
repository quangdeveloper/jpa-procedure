package vn.vnpay.persistenjpa.converter;

import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static UserDTO convertUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .status(user.getStatus())
                .email(user.getEmail())
                .roleId(user.getRoleId())
                .build();
    }


    public static List<UserDTO> convertUsersToUserDTOs(List<User> list) {
        List<UserDTO> userDTOs = new ArrayList<>();
        list.forEach(u -> userDTOs.add(convertUserToUserDTO(u)));
        return userDTOs;
    }
}

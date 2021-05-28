package vn.vnpay.persistenjpa.service;

import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.dto.UserLoginDTO;
import vn.vnpay.persistenjpa.search.ObjectSearch;

public interface UserService {

    ResponseDTO login(UserLoginDTO userLoginDTO);
    ResponseDTO getByFilter(ObjectSearch objectSearch);
    ResponseDTO getById(Long id);
    ResponseDTO create(UserDTO userDTO);
    ResponseDTO update(UserDTO userDTO);
}

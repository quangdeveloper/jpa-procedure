package vn.vnpay.persistenjpa.service;

import vn.vnpay.persistenjpa.dto.MovieDTO;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.entity.Movie;
import vn.vnpay.persistenjpa.entity.User;
import vn.vnpay.persistenjpa.search.ObjectSearch;

import java.util.List;

public interface UserService {

    User getById(Long id);
    User getByUserName(String user);
    User getByUserNameAndPassword(String  username, String password);
    List<User> getByFilter(ObjectSearch objectSearch);
    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
}

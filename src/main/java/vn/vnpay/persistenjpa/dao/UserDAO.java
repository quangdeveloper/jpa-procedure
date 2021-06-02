package vn.vnpay.persistenjpa.dao;

import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.entity.User;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.search.UserSearch;

import java.util.List;

public interface UserDAO {

    User getById(Long id);
    User getByUserName(String user);
    List<User> getByFilter(UserSearch objectSearch);
    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
}

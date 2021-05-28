package vn.vnpay.persistenjpa.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpay.persistenjpa.constant.ResponseCode;
import vn.vnpay.persistenjpa.constant.ResponseMessage;
import vn.vnpay.persistenjpa.entity.User;
import vn.vnpay.persistenjpa.exception.GeneralException;
import vn.vnpay.persistenjpa.dao.UserDAO;

@Slf4j
@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    /**
     *Lấy ra 1 userDetail thông qua tài username khi đăng nhập của người dùng
     *
     * hỏi anh xem tai sao yêu cầu lấy ra user detail nhưng hàm lại trả về userPrincipal
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDAO.getByUserName(s);

        if (user == null) {
            throw new GeneralException(ResponseCode.FAIL,
                ResponseMessage.LOGIN_FAIL);
        }
        return new UserPrincipal(user);
    }

    /**
     * Tìm user thông qua id cửa user
     *
     */

    public UserDetails loadUserById(Long id) {

        User user = userDAO.getById(id);

        if (user == null ){
            throw new GeneralException(ResponseCode.NOT_FOUND,
                    ResponseMessage.NOT_FOUND + " user " + id);
        }

        return new UserPrincipal(user);
    }
}

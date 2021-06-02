package vn.vnpay.persistenjpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.vnpay.persistenjpa.constant.ResponseCode;
import vn.vnpay.persistenjpa.constant.ResponseMessage;
import vn.vnpay.persistenjpa.converter.UserConverter;
import vn.vnpay.persistenjpa.dao.UserDAO;
import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.dto.UserLoginDTO;
import vn.vnpay.persistenjpa.entity.User;
import vn.vnpay.persistenjpa.jwt.JWTTokenProvider;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.search.UserSearch;
import vn.vnpay.persistenjpa.security.UserPrincipal;
import vn.vnpay.persistenjpa.service.UserService;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider jwtTokenProvider;

    @Autowired
    private UserDAO userDAO;

    @Override
    public ResponseDTO login(UserLoginDTO userLoginDTO) {

        try{
            /** lấy authentication ra để tạo theo kiểu token*/
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDTO.getUsername(),
                            userLoginDTO.getPassword()
                    )
            );

            /** thiết lập authentication */
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserPrincipal userPrincipal =  (UserPrincipal) authentication.getPrincipal();
            String jwt = jwtTokenProvider.generateToken(userPrincipal);

            UserDTO userDTO = UserDTO.builder()
                    .id(userPrincipal.getId())
                    .username(userPrincipal.getUsername())
                    .fullName(userPrincipal.getFullName())
                    .email(userPrincipal.getEmail())
                    .roleId(userPrincipal.getRoleId())
                    .status(userPrincipal.getActive())
                    .token(jwt)
                    .build();

            return ResponseDTO.builder()
                    .results(userDTO)
                    .code(ResponseCode.SUCCESS)
                    .message(ResponseMessage.SUCCESS)
                    .build();

        }catch (Exception exp){
            log.error("Authentication exception {}", exp.getMessage());
            return ResponseDTO.builder()
                    .results(null)
                    .code(ResponseCode.FAIL)
                    .message(ResponseMessage.LOGIN_FAIL)
                    .build();
        }
    }

    @Override
    public ResponseDTO getByFilter(UserSearch objectSearch) {

        List<UserDTO> userDTOs = UserConverter.convertUsersToUserDTOs(
                userDAO.getByFilter(objectSearch));

        return ResponseDTO.builder()
                .results(userDTOs)
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .build();
    }

    @Override
    public ResponseDTO getById(Long id) {

        UserDTO userDTO  = UserConverter.convertUserToUserDTO(
                userDAO.getById(id));

        return ResponseDTO.builder()
                .results(userDTO)
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .build();
    }

    @Override
    public ResponseDTO create(UserDTO userDTO) {


        UserDTO userRS  = UserConverter.convertUserToUserDTO(
                userDAO.create(userDTO));

        return ResponseDTO.builder()
                .results(userRS)
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .build();
    }

    @Override
    public ResponseDTO update(UserDTO userDTO) {

        UserDTO userRS  = UserConverter.convertUserToUserDTO(
                userDAO.update(userDTO));

        return ResponseDTO.builder()
                .results(userRS)
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .build();
    }
}

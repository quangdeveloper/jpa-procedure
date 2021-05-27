package vn.vnpay.persistenjpa.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.persistenjpa.constant.ResponseCode;
import vn.vnpay.persistenjpa.constant.ResponseMessage;
import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.dto.UserLoginDTO;
import vn.vnpay.persistenjpa.service.UserService;

@RestController
@Slf4j
public class AuthenController {


    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody UserLoginDTO user) {

        log.info("call api login");
        return null;
    }

}

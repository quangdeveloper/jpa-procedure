package vn.vnpay.persistenjpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.persistenjpa.constant.ResponseCode;
import vn.vnpay.persistenjpa.constant.ResponseMessage;
import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.enums.ActionEnum;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.dao.UserDAO;
import vn.vnpay.persistenjpa.search.UserSearch;
import vn.vnpay.persistenjpa.service.UserService;
import vn.vnpay.persistenjpa.validate.UserValidate;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    private UserService userService;

    @PostMapping("/get-by-filter")
    public ResponseEntity<ResponseDTO> getUserByFilter(@RequestBody UserSearch obj) {
        log.info("call api get by filter user");
        return ResponseEntity.ok(userService.getByFilter(obj));
    }


    @GetMapping("/get-by-id")
    public ResponseEntity<ResponseDTO> getById(@RequestParam("id") Long id) {
        log.info("call api get by id user");
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO obj) {
        log.info("call api create user ");
        Map<String, String> mapError = UserValidate.validateUser(obj, ActionEnum.ADD);
        if (!mapError.isEmpty()) {
            return ResponseEntity.ok(ResponseDTO.builder()
                    .code(ResponseCode.DATA_INVALID)
                    .message(ResponseMessage.DATA_INVALID)
                    .results(mapError)
                    .build());
        }
        return ResponseEntity.ok(userService.create(obj));
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO obj) {
        log.info("call api update movie ");
        return ResponseEntity.ok(userService.update(obj));
    }
}

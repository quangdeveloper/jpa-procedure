package vn.vnpay.persistenjpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.persistenjpa.constant.ResponseCode;
import vn.vnpay.persistenjpa.constant.ResponseMessage;
import vn.vnpay.persistenjpa.dto.MovieDTO;
import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.service.MovieService;
import vn.vnpay.persistenjpa.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    private UserService userService;

    @PostMapping("/get-by-filter")
    public Object getUserByFilter(@RequestBody ObjectSearch obj){
        log.info("call api get by filter movie");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(null)
                .build();
    }


    @GetMapping("/get-by-id")
    public Object getById(@RequestParam("id") Long id){
        log.info("call api get by filter movie");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(userService.getById(id))
                .build();
    }

    @PostMapping("/create")
    public Object createUser(@RequestBody UserDTO obj){

        log.info("call api create movie");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(userService.create(obj))
                .build();
    }

    @PostMapping("/update")
    public Object updateUser(@RequestBody UserDTO obj){
        log.info("call api update movie ");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(userService.update(obj))
                .build();
    }
}

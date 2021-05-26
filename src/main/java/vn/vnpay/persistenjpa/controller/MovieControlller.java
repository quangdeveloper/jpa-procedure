package vn.vnpay.persistenjpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.persistenjpa.constant.ResponseCode;
import vn.vnpay.persistenjpa.dto.MovieDTO;
import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.constant.ResponseMessage;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.service.MovieService;
@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieControlller {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public Object getAllMovie(){
        log.info("call api get all movie");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(movieService.getAllMovie())
                .build();
    }

    @GetMapping("/get-by-filter")
    public Object getMovieByFilter(@RequestBody ObjectSearch obj){
        log.info("call api get by filter movie");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(movieService.getByFilterMovie(obj))
                .build();
    }

    @PostMapping("/create")
    public Object createMovie(@RequestBody MovieDTO obj){

        log.info("call api create movie", "000");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(movieService.createMovie(obj))
                .build();
    }

    @PostMapping("/update")
    public Object updateMovie(@RequestBody MovieDTO obj){
        log.info("call api update movie {}", "0000");
        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(movieService.updateMovie(obj))
                .build();
    }
}

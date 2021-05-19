package vn.vnpay.persistenjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vnpay.persistenjpa.dto.ResponseCode;
import vn.vnpay.persistenjpa.dto.ResponseDTO;
import vn.vnpay.persistenjpa.dto.ResponseMessage;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieControlller {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public Object getAllMovie(){

        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(movieService.getAllMovie())
                .build();
    }

    @GetMapping("/get-by-filter")
    public Object getMovieByFilter(@RequestBody ObjectSearch obj){

        return ResponseDTO.builder()
                .code(ResponseCode.SUCCESS)
                .message(ResponseMessage.SUCCESS)
                .results(movieService.getByFilterMovie(obj))
                .build();
    }
}

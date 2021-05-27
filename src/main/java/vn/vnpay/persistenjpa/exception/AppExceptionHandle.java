package vn.vnpay.persistenjpa.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import vn.vnpay.persistenjpa.dto.ResponseDTO;


@ControllerAdvice
@Slf4j
public class AppExceptionHandle {

    @ExceptionHandler(value = {GeneralException.class})
    protected ResponseEntity<ResponseDTO> generalException(GeneralException ex, WebRequest re){
        final  ResponseDTO responseDTO = ResponseDTO.builder()
                .results(ex.getValue())
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        log.error("[FlowerExceptionControlHandler.GeneralException: {}]", ex.getMessage());
        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}

package kr.co.polycube.backendtest.core.error;

import kr.co.polycube.backendtest.core.error.ex.Exception400;
import kr.co.polycube.backendtest.core.error.ex.Exception404;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> ex400(Exception400 e){
        log.warn(e.getMessage());
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST); // http body, http header
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> ex404(Exception404 e){
        log.warn(e.getMessage());
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unknown(Exception e){
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorDTO("오류 : 관리자에게 문의하세요"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

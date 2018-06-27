package com.example.demo.exception;

import com.example.demo.business.util.CustomStatus;
import com.example.demo.vo.ResponseMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseMsg customException(CustomException ex) {

        switch (ex.getMessage()) {
            case "800":
                return new ResponseMsg(CustomStatus.INVALID_URL.getCode(), CustomStatus.INVALID_URL.getMsg());
            case "900":
                return new ResponseMsg(CustomStatus.API_CALL_FAIL.getCode(), CustomStatus.API_CALL_FAIL.getMsg());
            default:
                return new ResponseMsg(0, "");
        }
    }
}

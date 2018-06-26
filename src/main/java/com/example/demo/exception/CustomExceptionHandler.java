package com.example.demo.exception;

import com.example.vo.ResponseMsg;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseMsg customException(CustomException ex) {

        switch (ex.getMessage()){
            case "800" :
                return new ResponseMsg(800, "잘못된 URL 또는 해당 컨텐츠 요청에 실패하였습니다. 관리자에게 문의해 주세요.");
            case "900" :
                return new ResponseMsg(900, "API 호출이 실패하였습니다. API 컴포넌트를 확인해 주세요.");
            default:
                return new ResponseMsg(0,"");
        }
    }
}

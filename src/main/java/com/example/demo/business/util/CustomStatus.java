package com.example.demo.business.util;

import lombok.Getter;

@Getter
public enum CustomStatus {
    INVALID_URL(800, "잘못된 URL 또는 해당 컨텐츠 요청에 실패하였습니다. 관리자에게 문의해 주세요."),
    API_CALL_FAIL(900, "API 호출이 실패하였습니다. API 컴포넌트를 확인해 주세요."),
    FAILED_TO_SPECIFY_ENDPOINT(901, "oEmbed API End Point 지정에 실패하였습니다.");

    private int code;
    private String msg;

    CustomStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}

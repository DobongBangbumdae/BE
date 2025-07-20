package com.dobongzip.dobong.global.response;


import org.springframework.http.HttpStatus;

public enum StatusCode {
    SUCCESS(HttpStatus.OK, "SUCCESS200", "요청이 성공적으로 처리되었습니다."),


    FAILURE_TEST(HttpStatus.INTERNAL_SERVER_ERROR, "TEST001", "테스트 실패 응답입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER5001", "서버에서 알 수 없는 에러가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String description;

    StatusCode(HttpStatus httpStatus, String code, String description) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.description = description;
    }

    public HttpStatus getHttpStatus() { return this.httpStatus; }
    public String getCode() { return this.code; }
    public String getDescription() { return this.description; }
}



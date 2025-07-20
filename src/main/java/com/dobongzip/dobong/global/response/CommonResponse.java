package com.dobongzip.dobong.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResponse<T> {
    private boolean success;
    private T data;
    private Status status;

    public static <T> CommonResponse<T> onSuccess(StatusCode statusCode, T data) {
        return new CommonResponse<>(true, data, new Status(statusCode));
    }

    public static <T> CommonResponse<T> onFailure(StatusCode statusCode) {
        return new CommonResponse<>(false, null, new Status(statusCode));
    }

    @Getter
    @AllArgsConstructor
    public static class Status {
        private String code;
        private String message;

        public Status(StatusCode statusCode) {
            this.code = statusCode.getCode();
            this.message = statusCode.getDescription();
        }
    }
}

package com.dream.coffee.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    INVALID_PARAM(BAD_REQUEST, "올바른 파라미터 정보가 필요합니다."),
    INVALID_USER(BAD_REQUEST, "존재하지 않는 사용자입니다. 다시 선택해주세요.")
    ;

    private final HttpStatus httpStatus;
    private final String detail;

}

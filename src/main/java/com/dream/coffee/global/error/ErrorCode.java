package com.dream.coffee.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    INVALID_PARAM(BAD_REQUEST, "올바른 파라미터 정보가 필요합니다."),
    INVALID_USER(NOT_FOUND, "존재하지 않는 사용자입니다. 다시 선택해주세요."),


    ORDERED_USER(CONFLICT, "주문내역이 존재합니다. 주문내역을 확인해주세요."),
    ;

    private final HttpStatus httpStatus;
    private final String detail;

}

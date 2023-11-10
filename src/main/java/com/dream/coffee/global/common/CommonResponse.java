package com.dream.coffee.global.common;

import com.dream.coffee.global.error.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommonResponse<T> {
    private boolean result;
    private ErrorResponse error;
    private T data;
}

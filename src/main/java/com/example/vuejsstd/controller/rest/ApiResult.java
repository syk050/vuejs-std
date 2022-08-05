package com.example.vuejsstd.controller.rest;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResult<T> {
    @NotNull
    private T data;
    private String message;

    public ApiResult(T data) {
        this.data = data;
    }

    @Builder
    public ApiResult(T data, String message) {
        this.data = data;
        this.message = message;
    }
}

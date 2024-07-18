package kr.co.polycube.backendtest.core.util;

import lombok.Getter;

@Getter
public class ApiUtil<T> {
    private T data;

    public ApiUtil(T data) {
        this.data = data;
    }
}

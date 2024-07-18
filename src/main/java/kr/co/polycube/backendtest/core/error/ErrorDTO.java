package kr.co.polycube.backendtest.core.error;

import lombok.Getter;

@Getter
public class ErrorDTO {
    private String reason;

    public ErrorDTO(String reason) {
        this.reason = reason;
    }
}

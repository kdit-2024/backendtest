package kr.co.polycube.backendtest.core.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorDTO {
    private final String reason;
}

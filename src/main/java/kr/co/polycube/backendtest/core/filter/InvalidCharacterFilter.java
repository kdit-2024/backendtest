package kr.co.polycube.backendtest.core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.polycube.backendtest.core.error.ErrorDTO;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.regex.Pattern;

public class InvalidCharacterFilter implements Filter {

    private static final Pattern INVALID_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9?&=:./]");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String queryString = request.getQueryString();
        String requestURI = request.getRequestURI();

        if (containsInvalidCharacters(queryString) || containsInvalidCharacters(requestURI)) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(400);
            response.getWriter().println(new ErrorDTO("잘못된 특수문자 요청")); // 자동 flush
        } else {
            // 특수 문자가 없는 경우 필터 체인 계속 실행
            filterChain.doFilter(request, response);
        }
    }

    private boolean containsInvalidCharacters(String input) {
        return input != null && INVALID_CHAR_PATTERN.matcher(input).find();
    }

}

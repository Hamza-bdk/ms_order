package com.wafa.ms_order.common.filter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.List;

@Slf4j
@Component
public class LoggingRequestFilter extends CommonsRequestLoggingFilter {

    private static final List<String> IGNORED_URI = List.of("/actuator", "/api-docs", "/swagger-ui");

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return IGNORED_URI.stream().noneMatch(ignoredUri -> request.getRequestURI().contains(ignoredUri));
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info("New Request for '{}:{}'", request.getMethod(), request.getRequestURI());
    }

}

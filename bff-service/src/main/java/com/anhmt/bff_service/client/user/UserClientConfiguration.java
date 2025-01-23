package com.anhmt.bff_service.client.user;

import com.anhmt.bff_service.client.configuration.FeignConfig;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Slf4j
public class UserClientConfiguration extends FeignConfig implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        Optional.of(requestAttributes).ifPresent(request -> {
            HttpServletRequest httpServletRequest = request.getRequest();

            String bearer = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
            log.info("bearer: {}", bearer);

            if (bearer == null) {
                return;
            }

            requestTemplate.header(AUTHORIZATION_HEADER, bearer);
        });
    }
}

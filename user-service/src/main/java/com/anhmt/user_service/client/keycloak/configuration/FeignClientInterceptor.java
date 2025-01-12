//package com.anhmt.user_service.client.keycloak.configuration;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.util.Optional;
//
//@Component
//public class FeignClientInterceptor implements RequestInterceptor {
//    private static final String AUTHORIZATION_HEADER = "Authorization";
//
//    public static String getBearerTokenHeader() {
//        if (RequestContextHolder.getRequestAttributes() == null) {
//            return null;
//        }
//
//        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                .getRequest().getHeader(AUTHORIZATION_HEADER);
//
//    }
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        Optional.ofNullable(getBearerTokenHeader())
//                .ifPresent(token -> requestTemplate.header(AUTHORIZATION_HEADER, token));
//    }
//}

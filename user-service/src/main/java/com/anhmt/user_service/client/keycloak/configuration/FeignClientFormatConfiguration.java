package com.anhmt.user_service.client.keycloak.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.HttpMessageConverterCustomizer;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Collections;

@Configuration(proxyBeanMethods = false)
public class FeignClientFormatConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.valueOf("FULL");
    }

    @Bean
    public Encoder feignEncoder() {
        HttpMessageConverter<Object> jacksonConverter =
                new MappingJackson2HttpMessageConverter(customerEncoder());
        ObjectFactory<HttpMessageConverters> messageConverters =
                () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(messageConverters);
    }

    @Bean
    public Decoder feignDecoder(ObjectProvider<HttpMessageConverterCustomizer> customizers) {
        HttpMessageConverter<Object> jacksonConverter =
                new MappingJackson2HttpMessageConverter(customObjectMapper());
        ObjectFactory<HttpMessageConverters> messageConverters =
                () -> new HttpMessageConverters(false, Collections.singleton(jacksonConverter));
        return new ResponseEntityDecoder(new SpringDecoder(messageConverters, customizers));
    }

    public ObjectMapper customObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    private ObjectMapper customerEncoder() {
        return Jackson2ObjectMapperBuilder.json()
                .modules(new JavaTimeModule())
                .featuresToDisable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
                .serializationInclusion(JsonInclude.Include.NON_NULL) // ignore null fields
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
    }
}

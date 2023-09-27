package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        name = "custom.configuration.enabled",
        havingValue = "true",
        matchIfMissing = false
)
@ConditionalOnClass(name = "com.example.demo.configuration.ConfigurationEnabler")
public class MyConfiguration {

    @Bean(name = "colorRed")
    public String colorRed() {
        return "red";
    }

    @Bean(name = "colorBlue")
    public String colorBlue() {
        return "blue";
    }
}

package com.sample.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("registration.configproperties")
//@RefreshScope
public class GlobalProperties {
	private Map<String, Map<String, String>>  properties1;
	private Map<String, Map<String, String>>  properties2;
}

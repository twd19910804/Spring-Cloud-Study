package com.twd.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableConfigurationProperties({TestConfig.class})
public class ConsulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsulApplication.class).web(true).run(args);
	}

	@Autowired
	private TestConfig testConfig;
	@RequestMapping("/hi")
	public String home() {
		return "hi ,i'm miya " + testConfig.getName();
	}
}

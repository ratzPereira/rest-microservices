package com.ratz.apigateway.configuration;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouterLocator(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("MyParam", "Param"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
				
				//example how to redirect from a wrong uri ( -new )
				.route(p -> p.path("/currency-conversion-new/**").filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
	}
}

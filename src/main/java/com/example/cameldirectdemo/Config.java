package com.example.cameldirectdemo;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Bean
  public CamelContext camelContext() {
    return new DefaultCamelContext();
  }

  @Bean
  public ProducerTemplate producerTemplate(final CamelContext camelContext) {
    return camelContext.createProducerTemplate();
  }

}

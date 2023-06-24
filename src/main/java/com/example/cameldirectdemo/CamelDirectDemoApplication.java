package com.example.cameldirectdemo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//todo działa jak się dodaje routa tutaj, ale nie działa jak mam oddzielny komponent

@SpringBootApplication
public class CamelDirectDemoApplication {

  public static void main(final String[] args) throws Exception {
    final ApplicationContext context =
        SpringApplication.run(CamelDirectDemoApplication.class, args);

    final CamelContext camelContext = context.getBean(CamelContext.class);

    camelContext.addRoutes(new RouteBuilder() {
      @Override
      public void configure() throws Exception {
        from("direct:start")
            .log(">>> Message received: ${body}");
      }
    });


    camelContext.start();

    final Producer producer = context.getBean(Producer.class);
    System.out.println(">>>>>PRODUCING");
    producer.produce("hello world");
  }
}

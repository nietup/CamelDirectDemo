package com.example.cameldirectdemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {

  @Override
  public void configure() {
    from("direct:start")
        .log(">>> Message received: ${body}");
  }

}

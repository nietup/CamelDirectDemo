package com.example.cameldirectdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private final Producer producer;

  @Autowired
  public Controller(final Producer producer) {
    this.producer = producer;
  }

  @GetMapping(value = "/{message}")
  public String getTestData(@PathVariable final String message) {

    producer.produce(message);

    return message;
  }
}

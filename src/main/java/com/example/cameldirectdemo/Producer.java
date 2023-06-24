package com.example.cameldirectdemo;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {

  private final ProducerTemplate producerTemplate;

  @Autowired
  public Producer(final ProducerTemplate producerTemplate) {
    this.producerTemplate = producerTemplate;
  }

  void produce(final String body) {
    producerTemplate.sendBody("direct:start", body);
  }

}

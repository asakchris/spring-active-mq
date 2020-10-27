package org.example.config;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {
  @Bean("messageQueue")
  public Queue messageQueue() {
    return new ActiveMQQueue("message-queue");
  }
}

package org.example.config;

import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {
  @Value("${app.message-queue.name}")
  private String queue;

  @Bean("messageQueue")
  public Queue messageQueue() {
    return new ActiveMQQueue(queue);
  }
}

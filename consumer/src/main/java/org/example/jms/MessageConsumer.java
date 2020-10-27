package org.example.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {
  @JmsListener(destination = "message-queue", concurrency = "5")
  public void onMessage(String message) {
    log.info("Message received: {} ", message);
  }
}

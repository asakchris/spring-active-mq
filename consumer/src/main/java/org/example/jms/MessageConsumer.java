package org.example.jms;

import lombok.extern.slf4j.Slf4j;
import org.example.model.MessageVo;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {
  @JmsListener(destination = "message-queue", concurrency = "5")
  public void onMessage(MessageVo message) {
    log.info("Message received: {} ", message);
  }
}

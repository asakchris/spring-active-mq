package org.example.jms;

import lombok.extern.slf4j.Slf4j;
import org.example.model.MessageVo;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {
  @JmsListener(destination = "${app.message-queue.name}", concurrency = "${app.message-queue.concurrency}")
  public void onMessage(MessageVo message) {
    log.info("Message received: {} ", message);
  }
}

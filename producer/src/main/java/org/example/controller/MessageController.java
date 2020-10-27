package org.example.controller;

import javax.jms.Queue;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.MessageVo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class MessageController {

  @Qualifier("messageQueue")
  private final Queue messageQueue;

  private final JmsTemplate jmsTemplate;

  @PostMapping("/messages")
  @ResponseStatus(HttpStatus.CREATED)
  public MessageVo sendMessage(@Valid @RequestBody MessageVo message) {
    log.info("Received message: {}", message);
    jmsTemplate.convertAndSend(messageQueue, message);
    log.info("message posted successfully: {}", message);
    return message;
  }
}

package at.nacs.magic8ball.view.controller;

import at.nacs.magic8ball.view.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MessageController {

  private final List<String> messages;

  @ModelAttribute("messages")
  Message getRandomMessage() {
    Collections.shuffle(messages);
    return Message.builder()
                  .message(messages.get(0))
                  .build();
  }

  @GetMapping
  String page() {
    return "message";
  }
}

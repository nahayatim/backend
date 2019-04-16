package at.nacs.magic8ball.view.controller.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class MessagesConfiguration {

  @Getter
  @Setter
  List<String> messages;

  @Bean
  List<String> allMessages() {
    return messages;
  }
}

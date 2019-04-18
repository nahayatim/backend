package at.nacs.encoderui.communication;

import at.nacs.encoderui.view.model.ValidatedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EncoderClient {


  private final RestTemplate restTemplate;

  @Value("${client.url}")
  private String url;

  public String send(String validatedMessage) {
    return restTemplate.postForObject(url, validatedMessage, String.class);
  }
}


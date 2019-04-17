package at.nacs.encoderui.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EncoderClient {


  private final RestTemplate restTemplate;

  @Value("${client.server.url}")
  String url;

  public String send(String plainText) {
    return restTemplate.postForObject(url, plainText, String.class);
  }
}


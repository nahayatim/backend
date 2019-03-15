package at.nacs.encoder.business;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class CoderClient {


    @Value("${coderclient.server.url")
    private String url;

    private final RestTemplate restTemplate;

    public String getAnswer(String message){
        return Stream.of(message)
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .filter(e -> !e.equals(" "))
                .map(e -> restTemplate.postForObject("http://localhost:9001/morse",e,String.class))
                .filter(Objects::nonNull)
                .collect(Collectors.joining());
    }
}

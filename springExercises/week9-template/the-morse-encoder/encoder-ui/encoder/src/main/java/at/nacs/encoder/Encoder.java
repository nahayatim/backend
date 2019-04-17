package at.nacs.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

@Service
@RequiredArgsConstructor
public class Encoder {

    private final RestTemplate restTemplate;

    @Value("${morse.url}")
    private String morseUrl;

    public String encode(String message) {
        message = message.replaceAll(" ", "");
        String[] letters = message.split("");
        return Stream.of(letters)
                .map(toMorse())
                .collect(joining());
    }

    private Function<String, String> toMorse() {
        return letter -> restTemplate.postForObject(morseUrl, letter, String.class);
    }

}

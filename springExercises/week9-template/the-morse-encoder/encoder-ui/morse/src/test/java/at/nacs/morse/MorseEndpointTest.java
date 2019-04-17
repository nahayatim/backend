package at.nacs.morse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MorseEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/morse";

    @ParameterizedTest
    @CsvSource({
            "1, a",
            "2, b",
            "NOT SUPPORTED, c"
    })
    void encode(String expected, String letter) {
        String actual = restTemplate.postForObject(url, letter, String.class);

        assertThat(actual).isEqualTo(expected);
    }
}
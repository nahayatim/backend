package at.nacs.morse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MorseEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void post() {

        Assertions.assertThat(restTemplate.postForObject("/morse","A",String.class));
    }
}
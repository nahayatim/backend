package at.nacs.admission;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @MockBean
    RestTemplate restTemplate;
    //DiagnosesClient diagnosesClient;
    String url = "/patients";

    @Test
    void admission() {
        Patient patient = Patient.builder().name("mahtab").symptoms("fiber").build();
        Patient response = testRestTemplate.postForObject(url, patient, Patient.class);

        assertThat(response.getName()).isEqualTo("mahtab");
        assertThat(response.getSymptoms()).isEqualTo("fiber");
        assertThat(response.getId()).isNotEmpty();


    }
}

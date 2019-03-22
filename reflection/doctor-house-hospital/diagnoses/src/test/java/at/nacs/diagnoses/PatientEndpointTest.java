package at.nacs.diagnoses;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;
    String url = "/patients";

    @Test
    void diagnose() {
        Patient patient = Patient.builder().name("mahtab").diagnosis("Lupus").build();
        Patient response = testRestTemplate.postForObject(url, patient, Patient.class);

        Assertions.assertThat(response.getName()).isEqualTo("mahtab");
        Assertions.assertThat(response.getDiagnosis()).isEqualTo("Lupus");
        Assertions.assertThat(response.getDiagnosis()).isNotEmpty();

    }
}


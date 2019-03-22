package at.nacs.admission;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    RestTemplate restTemplate;


    @Test
    void admit() {
        Patient patient = Patient.builder().name("sahar").symptoms("backache").build();

        Patient actual = admission.admit(patient);

        Assertions.assertThat(patient.getId()).isNotEmpty();


    }
}
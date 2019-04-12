package at.nacs.beds.communication;

import at.nacs.beds.logic.Nurse;
import at.nacs.beds.persistence.domain.Patient;
import at.nacs.beds.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment= RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

//    @MockBean
//    AccountancyClient accountancyClient;
//
//    @MockBean
//    PatientRepository patientRepository;

    @MockBean
    Nurse nurse;

    String url= "/patients";


    @Test
    void post() {
        Patient patient = Patient.builder().name("ani").symptoms("cough").diagnosis("cold").build();
        restTemplate.postForObject(url,patient,Patient.class);
        Mockito.verify(nurse).register(patient);

    }
}
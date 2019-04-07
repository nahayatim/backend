package at.nacs.drhousepharmacy.communication;


import at.nacs.drhousepharmacy.logic.Apothecary;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    PatientsEndpoint patientsEndpoint;

    @MockBean
    PatientRepository patientRepository;

    @MockBean
    AccountancyClient accountancyClient;

    @SpyBean
    Apothecary apothecary;

    String url="/patients";

    @Test
    void post() {
        Patient patient = Patient.builder().diagnosis("Cough").build();
        restTemplate.postForObject(url,patient,Patient.class);
        Mockito.verify(apothecary).provideMedicine(patient);

    }
}
package at.nacs.beds.logic;

import at.nacs.beds.communication.AccountancyClient;
import at.nacs.beds.persistence.domain.Patient;
import at.nacs.beds.persistence.repository.PatientRepository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class NurseTest {

    @MockBean
    AccountancyClient accountancyClient;

    @Autowired
    Nurse nurse;

    @Autowired
    PatientRepository repository;

    @Test
    void register() {
        Patient patient = Patient.builder().diagnosis("cold").build();
        nurse.provideTreatment(patient);
        assertThat(patient.getTreatment()).isEqualTo("mexalen");
    }

}
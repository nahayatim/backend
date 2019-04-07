package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class ApothecaryTest {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    Apothecary apothecary;

    @MockBean
    AccountancyClient accountancyClient;

    @Test
    void provideMedicine() {
        Patient patient = Patient.builder().diagnosis("diabet").build();
        apothecary.provideMedicine(patient);
        assertThat(patient.getMedicine()).isEqualTo("metformin");
    }
}
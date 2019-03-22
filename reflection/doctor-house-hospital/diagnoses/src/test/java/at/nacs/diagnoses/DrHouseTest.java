package at.nacs.diagnoses;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class DrHouseTest {

    @Autowired
    DrHouse drHouse;

    @Test
    void observe() {

        Patient patient = Patient.builder().name("ss").diagnosis("backache").build();
        Patient actual = drHouse.observe(patient);
        Assertions.assertThat(patient.getDiagnosis()).isNotEmpty();
    }
}
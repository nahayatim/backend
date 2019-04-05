package at.nacs.beds.communication;

import at.nacs.beds.logic.PatientManager;
import at.nacs.beds.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final PatientManager patientManager;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        patientManager.register(patient);
        return patient;
    }
}

package at.nacs.beds.communication;

import at.nacs.beds.logic.Nurse;
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

    private final Nurse nurse;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        nurse.register(patient);
        return patient;
    }
}

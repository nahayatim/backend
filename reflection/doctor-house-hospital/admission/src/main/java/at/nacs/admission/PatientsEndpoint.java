package at.nacs.admission;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {

    private final Admission admission;

    @PostMapping
    Patient admission(@RequestBody Patient patient) {
        admission.admit(patient);

        return patient;
    }
}

package at.nacs.diagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientEndpoint {

    private final DrHouse drHouse;

    @PostMapping
    Patient diagnose(@RequestBody Patient patient) {
        drHouse.observe(patient);

        return patient;

    }

}

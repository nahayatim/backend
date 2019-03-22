package at.nacs.diagnoses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class DrHouse {


    Patient observe(@RequestBody Patient patient) {
        patient.setDiagnosis("Lupus");
        return patient;
    }
}


package at.nacs.admission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class Admission {

    private final DiagnosesClient diagnosesClient;


    Patient admit(Patient patient) {

        String id = UUID.randomUUID().toString();
        patient.setId(id);
        diagnosesClient.forward(patient);
        return patient;
    }
}

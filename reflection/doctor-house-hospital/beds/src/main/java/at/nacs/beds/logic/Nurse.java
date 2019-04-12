package at.nacs.beds.logic;

import at.nacs.beds.communication.AccountancyClient;
import at.nacs.beds.persistence.domain.Patient;
import at.nacs.beds.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class Nurse {

    private final Map<String, String> treatments;

    private final PatientRepository patientRepository;
    private final AccountancyClient accountancyClient;

    public Patient register(Patient patient) {
        provideTreatment(patient);
        accountancyClient.forward(patient);
        patientRepository.save(patient);
        return patient;

    }


    private void provideTreatment(Patient patient) {
        String treatment = treatments.get(patient.getDiagnosis());
        patient.setTreatment(treatment);

    }
}
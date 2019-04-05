package at.nacs.beds.logic;

import at.nacs.beds.persistence.domain.Patient;
import at.nacs.beds.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientManager {

    private final PatientRepository patientRepository;
    private final Nurse nurse;

    public Patient register(Patient patient) {
        nurse.provideTreatment(patient);
        patientRepository.save(patient);
        return patient;
    }
}

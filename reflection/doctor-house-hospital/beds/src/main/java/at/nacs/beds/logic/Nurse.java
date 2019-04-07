package at.nacs.beds.logic;

import at.nacs.beds.communication.AccountancyClient;
import at.nacs.beds.persistence.domain.Patient;
import at.nacs.beds.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("patient")
@RequiredArgsConstructor
public class Nurse {


    private final Map<String, String> treatment;

    private final PatientRepository patientRepository;
    private final AccountancyClient accountancyClient;

    public Patient register(Patient patient) {
        provideTreatment(patient);
        accountancyClient.forward(patient);
        patientRepository.save(patient);
        return patient;

    }


    public void provideTreatment(Patient patient) {
        String diagnosis = treatment.get(patient.getDiagnosis());
        patient.setTreatment(diagnosis);

    }
}
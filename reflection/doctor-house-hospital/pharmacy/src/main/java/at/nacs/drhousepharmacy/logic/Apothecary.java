package at.nacs.drhousepharmacy.logic;

import at.nacs.drhousepharmacy.communication.AccountancyClient;
import at.nacs.drhousepharmacy.persistence.domain.Patient;
import at.nacs.drhousepharmacy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Apothecary {

    private final PatientRepository patientRepository;
    private final AccountancyClient accountancyClient;


    public Patient provideMedicine(Patient patient) {
        patient.setMedicine("metformin");
        accountancyClient.forward(patient);
        patientRepository.save(patient);
        return patient;

    }
}

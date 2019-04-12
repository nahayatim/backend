package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientManager {

  private final PatientRepository patientRepository;

  public Patient create(PatientDTO patientDTO) {
    return Patient.builder()
                  .name(patientDTO.getName())
                  .uuid(patientDTO.getId())
                  .build();
  }

  public void save(Patient patient) {
    patientRepository.save(patient);
  }


}

package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvoiceCreator {

  public Invoice createInvoice(PatientDTO patientDTO, Patient patient) {
    return Invoice.builder()
                  .patient(patient)
                  .kind(getKind(patientDTO))
                  .symptoms(patientDTO.getSymptoms())
                  .diagnosis(patientDTO.getDiagnosis())
                  .provided(getProvided(patientDTO))
                  .cost(0.0)
                  .paid(false)
                  .timestamp(LocalDateTime.now())
                  .build();

  }

  private Kind getKind(PatientDTO patientDTO) {
    if (patientDTO.getMedicine() != null) {
      return Kind.MEDICINE;
    }
    return Kind.TREATMENT;
  }

  private String getProvided(PatientDTO patientDTO) {
    if (patientDTO.getMedicine() == null) {
      return patientDTO.getTreatment();
    }
    return patientDTO.getMedicine();
  }

}

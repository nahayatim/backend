package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.dto.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/patients")
@RequiredArgsConstructor
@RestController
public class PatientEndpoint {

  private final Accountant accountant;

  @PostMapping
  public PatientDTO post(@RequestBody PatientDTO patientDTO) {
    accountant.post(patientDTO);
    return patientDTO;
  }
}

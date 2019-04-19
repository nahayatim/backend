package at.nacs.drhouseadministration.communication;

import at.nacs.drhouseadministration.view.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AdmissionsClient {

  private final RestTemplate restTemplate;

  @Value("${admissions.url}")
  private String url;

  public void admit(Patient patient) {
    restTemplate.postForObject(url, patient, Patient.class);
  }
}

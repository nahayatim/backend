package at.nacs.beds.communication;

import at.nacs.beds.persistence.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AccountancyClient {

    private final RestTemplate restTemplate;

    @Value("${patient.url}")
    private String url;


    public void forward(Patient patient) {

        restTemplate.postForObject(url, patient, Patient.class);

    }

}

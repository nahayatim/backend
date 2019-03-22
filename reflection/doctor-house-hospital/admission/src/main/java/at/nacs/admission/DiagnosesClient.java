package at.nacs.admission;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class DiagnosesClient {

    private final RestTemplate restTemplate;

    @Value("${patients.url}")
    private String url;


    public void forward(Patient patient) {

        restTemplate.postForObject(url, patient, Patient.class);

    }
}

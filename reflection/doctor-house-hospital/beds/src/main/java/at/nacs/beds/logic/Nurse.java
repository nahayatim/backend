package at.nacs.beds.logic;

import at.nacs.beds.persistence.domain.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Service
@ConfigurationProperties("patient")
public class Nurse {

    @Getter
    @Setter
    private Map<String, String> treatment;


    public Patient provideTreatment(Patient patient) {
        String diagnosis = patient.getDiagnosis();
        patient.setTreatment(diagnosis);
        return patient;

    }
}
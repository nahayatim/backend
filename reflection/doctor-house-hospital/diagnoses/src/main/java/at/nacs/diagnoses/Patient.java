package at.nacs.diagnoses;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Builder
public class Patient {

    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;


}

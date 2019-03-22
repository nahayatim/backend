package at.nacs.admission;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Patient {

    private String id;
    private String name;
    private String symptoms;
}

package at.nacs.ex01;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@ConfigurationProperties("specific")
public class BallerinaLoader {

    private List<Ballerina> ballerinas;
}

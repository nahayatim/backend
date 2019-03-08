package at.nacs.ex01;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("entertainment")
public class SaunaLoader {
    private Sauna sauna;
}

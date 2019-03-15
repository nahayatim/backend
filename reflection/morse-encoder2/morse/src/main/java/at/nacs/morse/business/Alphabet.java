package at.nacs.morse.business;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@Getter
@Setter
@ConfigurationProperties("letter")
public class Alphabet {
    private Map<String, String> morsealphabet;
}

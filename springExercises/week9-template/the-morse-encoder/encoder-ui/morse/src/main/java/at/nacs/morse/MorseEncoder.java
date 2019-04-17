package at.nacs.morse;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ConfigurationProperties("translation")
public class MorseEncoder {

    @Setter
    private Map<String, String> morse;

    @Setter
    private String notSupported;

    public String encode(String letter) {
        String upperCase = letter.toUpperCase();
        return morse.getOrDefault(upperCase, notSupported);
    }

}

package at.nacs.beds;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties("infobank")
@Configuration
public class TreatmentConfiguration {

    @Setter
    @Getter
    private Map<String, String> treatment;

    @Bean
    Map<String, String> treatment() {
        return treatment;
    }

}

package at.nacs.beds.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties("patient")
@Configuration
public class TreatmentsConfiguration {

    @Setter
    @Getter
    private Map<String, String> treatments;

    @Bean
    Map<String, String> treatment() {
        return treatments;
    }

}

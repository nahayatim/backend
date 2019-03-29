package at.nacs.admission;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ResttemplateConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
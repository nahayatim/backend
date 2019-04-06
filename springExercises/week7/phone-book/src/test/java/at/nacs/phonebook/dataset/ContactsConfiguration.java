package at.nacs.phonebook.dataset;

import at.nacs.phonebook.persistence.domain.Contact;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("dataset")
public class ContactsConfiguration {

    @Getter
    @Setter
    List<Contact> contacts;

    @Bean
    List<Contact> contacts() {
        return contacts;
    }
}

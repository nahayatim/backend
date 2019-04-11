package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.domain.Contact;
import at.nacs.phonebook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class ContactsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    List<Contact>contacts;

    @SpyBean
    ContactManager contactManager;

    @MockBean
    ContactRepository contactRepository;


    final String url="/contacts";


    @Test
    void get() {
        testRestTemplate.getForObject(url,Contact[].class);

        verify(contactManager).findAll();
    }

    @Test
    void post() {
        Contact contact = contacts.get(0);
        testRestTemplate.postForObject(url,contact,Contact.class);

        verify(contactManager).save(contact);
    }

    @Test
    void getByAddress() {
        String address="fake-address";
        String getByAddressURL= url+"/address"+address;

        testRestTemplate.getForObject(getByAddressURL,Contact[].class);

        verify(contactManager).findBy(address);
    }
}
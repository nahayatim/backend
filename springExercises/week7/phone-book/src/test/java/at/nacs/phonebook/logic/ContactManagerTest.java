package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.domain.Contact;
import at.nacs.phonebook.persistence.repository.ContactRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class ContactManagerTest {

    @Autowired
    ContactManager contactManager;

    @Autowired
    ContactRepository contactRepository;

   @Autowired
    List<Contact>contacts;

    @BeforeEach
    void before() {
        contactRepository.saveAll(contacts);
    }

    @AfterEach
    void after(){
        contactRepository.deleteAll();
    }

    @Test
    void findAll() {

        List<Contact> actual = contactManager.findAll();
        assertThat(actual.size()).isEqualTo(1);

    }

    @Test
    void save() {
        Contact contact = contacts.get(0);
        String name= "test man";
        contact.setName(name);

        Contact actual = contactManager.save(contact);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getName()).isEqualTo(name);
        assertThat(contactRepository.count()).isEqualTo(3);
    }


    @Test
    void findLike() {
        List<Contact> test = contactManager.findLike("test");

        assertThat(test.size()).isEqualTo(1);
    }
}
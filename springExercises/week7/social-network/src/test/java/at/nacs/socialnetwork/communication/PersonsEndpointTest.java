package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistence.domain.Person;
import at.nacs.socialnetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PersonsEndpointTest {

  final String url = "/persons";

  @Autowired
  PersonsEndpoint endpoint;

  @MockBean
  PersonRepository repository;

  @Autowired
  TestRestTemplate restTemplate;

  @SpyBean
  PersonManager manager;

  @Autowired
  List<Person> persons;

  @Test
  void get() {
    restTemplate.getForObject(url, Person[].class);
    verify(manager).findAll();
  }

  @Test
  void getAllWithFriends() {
    String withURL = url + "/friends/with";

    restTemplate.getForObject(withURL, Person[].class);

    verify(manager).findPersonWithAtleastOneFriend();
  }

  @Test
  void getAllWithoutFriends() {
    String withoutURL = url + "/friends/without";

    restTemplate.getForObject(withoutURL, Person[].class);

    verify(manager).findPersonWithoutFriends();
  }


  @Test
  void post() {
    Person person = persons.get(0);

    restTemplate.postForObject(url,person,Person[].class);

    verify(manager).save(person);
  }

  @Test
  void friend() {
    Person person1 = persons.get(0);
    person1.setId(1L);
    Person person2 = persons.get(1);
    person2.setId(2L);
    String friendURL= url+"/"+person1.getId()+"/friend/"+person2.getId();

    restTemplate.put(friendURL,Person[].class);

    verify(manager).connectTwoPerson(person1.getId(),person2.getId());
  }

  @Test
  void unfriend() {
    Person person1 = persons.get(0);
    person1.setId(1L);
    Person person2 = persons.get(1);
    person2.setId(2L);
    String unfriendURL=url+"/"+person1.getId()+"/unfriend/"+person2.getId();

    restTemplate.put(unfriendURL,Person[].class);

    verify(manager).disconnectTwoPerson(person1.getId(),person2.getId());
  }
}
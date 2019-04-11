package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.domain.Person;
import at.nacs.socialnetwork.persistence.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class PersonManagerTest {

  @Autowired
  PersonManager manager;

  @Autowired
  PersonRepository repository;

  @Autowired
  List<Person> persons;

  @BeforeEach
  void before() {
    repository.deleteAll();
    repository.saveAll(persons);
  }

  @Test
  void findAll() {
    List<Person> actual = manager.findAll();
    assertThat(actual.size()).isEqualTo(2);
  }

  @Test
  void save() {
    Person person = persons.get(0);
    String name = "ania";
    person.setName(name);

    Person actual = manager.save(person);

    assertThat(actual).isNotNull();
    assertThat(actual.getId()).isNotNull();
    assertThat(actual.getName()).isEqualTo(name);
    assertThat(repository.count()).isEqualTo(3);
  }

  @Test
  void findPersonWithAtleastOneFriend() {
    List<Person> actual = manager.findPersonWithAtleastOneFriend();

    assertThat(actual.size()).isEqualTo(0);

    List<Person> all = repository.findAll();
    manager.connectTwoPerson(all.get(0).getId(), all.get(1).getId());

    actual = manager.findPersonWithAtleastOneFriend();

    assertThat(actual.size()).isEqualTo(2);
  }

  @Test
  void findPersonWithoutFriends() {
    List<Person> actual = manager.findPersonWithoutFriends();

    assertThat(actual.size()).isEqualTo(2);

    List<Person> all = repository.findAll();
    manager.connectTwoPerson(all.get(0).getId(), all.get(1).getId());

    actual = manager.findPersonWithoutFriends();

    assertThat(actual.size()).isEqualTo(0);
  }

  @Test
  void connectTwoPerson() {
    List<Person> all = repository.findAll();
    Person person1 = all.get(0);
    Person person2 = all.get(1);

    assertThat(person1.getFriends()).isEmpty();
    assertThat(person2.getFriends()).isEmpty();

    manager.connectTwoPerson(person1.getId(), person2.getId());

    all = repository.findAll();
    person1 = all.get(0);
    person2 = all.get(1);

    assertThat(person1.getFriends()).isNotEmpty();
    assertThat(person2.getFriends()).isNotEmpty();
    assertThat(person1.getFriends().get(0)).isEqualTo(person2);
    assertThat(person2.getFriends().get(0)).isEqualTo(person1);
  }

  @Test
  void disconnectTwoPerson() {
    List<Person> all = repository.findAll();
    manager.connectTwoPerson(all.get(0).getId(), all.get(1).getId());

    all = repository.findAll();
    Person person1 = all.get(0);
    Person person2 = all.get(1);

    assertThat(person1.getFriends()).isNotEmpty();
    assertThat(person2.getFriends()).isNotEmpty();

    manager.disconnectTwoPerson(person1.getId(), person2.getId());

    all = repository.findAll();
    person1 = all.get(0);
    person2 = all.get(1);

    assertThat(person1.getFriends()).isEmpty();
    assertThat(person2.getFriends()).isEmpty();
  }
}
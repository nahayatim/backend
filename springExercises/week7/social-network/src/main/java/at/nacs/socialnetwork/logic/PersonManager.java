package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.domain.Person;
import at.nacs.socialnetwork.persistence.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }


    public Person save(Person person) {
        return personRepository.save(person);
    }


    public List<Person> findPersonWithAtleastOneFriend() {
        return personRepository.findByFriendsNotEmpty();
    }

    public List<Person> findPersonWithoutFriends() {
        return personRepository.findByFriendsEmpty();
    }

    public void connectTwoPerson(Long id1, Long id2) {
        BiConsumer<Person, Person> friend = (person1, person2) -> {
            person1.getFriends().add(person2);
            person2.getFriends().add(person1);
        };
        operate(id1, id2, friend);
    }

    public void disconnectTwoPerson(Long id1, Long id2) {
        BiConsumer<Person, Person> unfriend = (person1, person2) -> {
            person1.getFriends().remove(person2);
            person2.getFriends().remove(person1);
        };
        operate(id1, id2, unfriend);
    }

    private void operate(Long id1, Long id2, BiConsumer<Person, Person> operation) {
        {
            Optional<Person> byId1 = personRepository.findById(id1);
            Optional<Person> byId2 = personRepository.findById(id2);
            if (byId1.isEmpty() || byId2.isEmpty()) {
                return;
            }
            Person person1 = byId1.get();
            Person person2 = byId2.get();

            operation.accept(person1, person2);

            personRepository.save(person1);
            personRepository.save(person2);
        }

    }
}

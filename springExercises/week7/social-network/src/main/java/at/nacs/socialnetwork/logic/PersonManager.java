package at.nacs.socialnetwork.logic;

import at.nacs.socialnetwork.persistence.Person;
import at.nacs.socialnetwork.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final PersonRepository personRepository;

    public List<Person>findAll(){
        return personRepository.findAll();
    }

    public List<Person>findPersonWithAtleastOneFriend(){
        return personRepository.findAllByFriendsIsNotNull();
    }

    public List<Person>findPersonWithNoFriends(){
        return personRepository.findAllByFriendsIsNull();
    }

    public void connectTwoPerson(Long id1,Long id2){
        Person person1 = personRepository.findById(id1).get();
        Person person2 = personRepository.findById(id2).get();

        person1.getFriends().add(person2);
        person2.getFriends().add(person1);

        personRepository.save(person1);
        personRepository.save(person2);
    }

    public void disconnectTwoPerson(Long id1,Long id2){
        Person person1 = personRepository.findById(id1).get();
        Person person2 = personRepository.findById(id2).get();

        person1.getFriends().remove(person2);
        person2.getFriends().remove(person1);

        personRepository.delete(person1);
        personRepository.delete(person2);

        personRepository.save(person1);
        personRepository.save(person2);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }
}

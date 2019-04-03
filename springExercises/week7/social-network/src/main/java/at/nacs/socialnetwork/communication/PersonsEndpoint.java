package at.nacs.socialnetwork.communication;

import at.nacs.socialnetwork.logic.PersonManager;
import at.nacs.socialnetwork.persistence.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonsEndpoint {

    private final PersonManager personManager;

    @GetMapping
    List<Person> get(){
        return personManager.findAll();
    }

    @GetMapping("/friends/with")
    List<Person> getAllWithFriends(){
        return personManager.findPersonWithAtleastOneFriend();
    }

    @GetMapping("/friends/without")
    List<Person>getAllWithoutFriends(){
        return  personManager.findPersonWithNoFriends();
    }

    @PostMapping
    Person post(@RequestBody Person person){
        return personManager.save(person);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void beFriendTwoPersons(@PathVariable Long id1,Long id2){
        personManager.connectTwoPerson(id1,id2);
    }

    @PutMapping("/{id1}/friend/{id2}")
    void unFriendTwoPersons(@PathVariable Long id1,Long id2){
        personManager.disconnectTwoPerson(id1,id2);
    }
}

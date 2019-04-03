package at.nacs.socialnetwork.repository;

import at.nacs.socialnetwork.persistence.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByFriendsIsNotNull();
    List<Person> findAllByFriendsIsNull();


}

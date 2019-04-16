package at.nacs.socialnetwork.persistence.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data
@EqualsAndHashCode(exclude = "friends")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(fetch = EAGER)
    private List<Person> friends = new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", friends=" + friends.stream().map(Person::getName).collect(toList()) +
                '}';
    }
}

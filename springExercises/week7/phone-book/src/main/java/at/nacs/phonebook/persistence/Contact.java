package at.nacs.phonebook;

import lombok.Data;
import org.apache.tomcat.jni.Address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private Address address;
}

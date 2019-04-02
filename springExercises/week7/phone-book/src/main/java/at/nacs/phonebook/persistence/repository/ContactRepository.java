package at.nacs.phonebook.persistence.repository;

import at.nacs.phonebook.persistence.Address;
import at.nacs.phonebook.persistence.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findContactsByAddressIsLike(Address address);

}
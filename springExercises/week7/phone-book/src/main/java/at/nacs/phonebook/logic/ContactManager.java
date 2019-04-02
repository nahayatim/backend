package at.nacs.phonebook.logic;

import at.nacs.phonebook.persistence.Address;
import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository contactRepository;


    public List<Contact>findAll(){
        return contactRepository.findAll();
    }

    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> findLike(Address address){
        return contactRepository.findContactsByAddressIsLike(address);



    }
}

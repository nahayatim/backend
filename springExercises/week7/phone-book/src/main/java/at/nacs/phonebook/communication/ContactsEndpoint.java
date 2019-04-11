package at.nacs.phonebook.communication;

import at.nacs.phonebook.logic.ContactManager;
import at.nacs.phonebook.persistence.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactsEndpoint {

    private final ContactManager contactManager;

    @GetMapping
    List<Contact> get() {
        return contactManager.findAll();
    }

    @PostMapping
    Contact post(@RequestBody Contact contact) {
        return contactManager.save(contact);
    }

    @GetMapping("/address/{address}")
    List<Contact> getByAddress(@PathVariable String address) {
        return contactManager.findBy(address);
    }


}

package at.nacs.todos.persistence;

import at.nacs.todos.persistence.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String> {

}

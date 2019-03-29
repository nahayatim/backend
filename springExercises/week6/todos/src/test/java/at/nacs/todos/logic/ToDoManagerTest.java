package at.nacs.todos.logic;

import at.nacs.todos.persistence.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    ToDo toDo;

    @BeforeEach
    void before(){
        toDoManager.deleteAll();
        ToDo toDo = ToDo.builder().title("Test").build();
    }

    @org.junit.jupiter.api.Test
    void findAll() {
    }

    @org.junit.jupiter.api.Test
    void findOne() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void markAsDone() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void deleteAll() {
    }
}
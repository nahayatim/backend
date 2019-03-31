package at.nacs.todos.logic;

import at.nacs.todos.persistence.ToDo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ToDoManagerTest {

    @Autowired
    ToDoManager toDoManager;

    ToDo toDo;

    @BeforeEach
    void before() {
        toDoManager.deleteAll();
        ToDo toDo = ToDo.builder().title("Test").build();
    }

    @Test
    void findAll() {
        List<ToDo> todos = toDoManager.findAll();
        assertThat(todos).isEmpty();
    }

    @Test
    void findOne() {
        toDoManager.save(toDo);

        Optional<ToDo> actual = toDoManager.findOne(toDo.getId());
        actual.ifPresent(e -> assertThat(e).isEqualTo(toDo));

    }

    @Test
    void save() {
        toDoManager.save(toDo);

        Optional<ToDo> actual = toDoManager.findOne(toDo.getId());
        actual.ifPresent(e -> assertThat(e).isEqualTo(toDo));
    }

    @Test
    void markAsDone() {
        toDoManager.save(toDo);
        String id = toDo.getId();

        toDoManager.markAsDone(id);

        Optional<ToDo> actual = toDoManager.findOne(id);
        actual.ifPresent(e -> assertThat(e.isDone()).isTrue());
    }

    @Test
    void delete() {
        toDoManager.save(toDo);
        String id = toDo.getId();
        assertThat(toDo.getId()).isNotBlank();

        toDoManager.delete(id);

        Optional<ToDo> actual = toDoManager.findOne(id);
        assertThat(actual.isPresent()).isFalse();
    }

    @Test
    void deleteAll() {
    }
}
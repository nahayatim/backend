package at.nacs.todos.endpoint;

import at.nacs.todos.logic.ToDoManager;
import at.nacs.todos.persistence.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ToDosEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    @SpyBean
    ToDoManager toDoManager;

    String url="/todos";

    ToDo toDo;

    @BeforeEach
    void before(){
        toDoManager.deleteAll();
        ToDo.builder().title("test").build();
    }

    @Test
    void get() {
        ToDo[] response = restTemplate.getForObject(url, ToDo[].class);

        assertThat(response).isEmpty();
        verify(toDoManager).findAll();

    }


    @Test
    void getOne() {
        toDoManager.save(toDo);
        String id = toDo.getId();
        String todoUrl = this.url + "/" + id;

        ToDo actual = restTemplate.getForObject(todoUrl, ToDo.class);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotBlank();
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(toDo.getTitle());
        assertThat(actual.isDone()).isFalse();
        verify(toDoManager).findOne(id);
    }

    @Test
    void post() {
        ToDo saved = restTemplate.postForObject(url, this.toDo, ToDo.class);
        String id = saved.getId();

        Optional<ToDo> oToDo = toDoManager.findOne(id);
        assertThat(oToDo.isPresent()).isTrue();
        ToDo actual = oToDo.get();

        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(saved.getTitle());
        assertThat(actual.isDone()).isFalse();
        verify(toDoManager).save(actual);


    }

    @Test
    void put() {
        toDoManager.save(toDo);
        String id = toDo.getId();
        String todoUrl = this.url + "/" + id + "/done";

        assertThat(toDo.isDone()).isFalse();

        restTemplate.put(todoUrl, null);

        Optional<ToDo> oToDo = toDoManager.findOne(id);
        assertThat(oToDo.isPresent()).isTrue();
        ToDo actual = oToDo.get();

        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(toDo.getTitle());
        assertThat(actual.isDone()).isTrue();
        verify(toDoManager).save(toDo);
    }

    @Test
    void delete() {
        toDoManager.save(toDo);
        String id = toDo.getId();
        String todoUrl = this.url + "/" + id;

        restTemplate.delete(todoUrl);

        Optional<ToDo> oToDo = toDoManager.findOne(id);
        assertThat(oToDo.isPresent()).isFalse();

    }
}
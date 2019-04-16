package at.nacs.twitter.logic;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class TwitterTest {

    @Autowired
    Twitter twitter;

    @Test
    void findAll() {
    }

    @org.junit.jupiter.api.Test
    void findBy() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void like() {
    }

    @org.junit.jupiter.api.Test
    void comment() {
    }
}
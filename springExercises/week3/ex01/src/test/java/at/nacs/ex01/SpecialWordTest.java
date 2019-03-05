package at.nacs.ex01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpecialWordTest {

    @Autowired
    SpecialWord specialWord;

    @Test
    void getWord() {
        String word = specialWord.getWord();
        Assertions.assertEquals("fantastic", word);
    }
}
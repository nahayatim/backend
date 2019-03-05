package at.nacs.ex01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NumberTest {

    @Autowired
    Number number;

    @Test
    void getNumber() {
        Integer number = this.number.getNumber();
        Integer expected = 369;
        Assertions.assertEquals(expected, number);
    }
}
package de.nacs.handshake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransformerTest {

    @Autowired
    Transformer transformer;

    @ParameterizedTest
    @CsvSource({
            "thumb touches back - tickles over palm - bro knock,256",
            "little finger grab - tickles over palm - thousand knuckles,359",
            "little finger grab - bro knock - thumb touches back,362"
    })
    void testHandshake(String handshake, Integer price) {
        List<String> actual = transformer.transform(price);
        List<String> expected = List.of(handshake.split(" - "));
        Assertions.assertEquals(expected, actual);

    }

}

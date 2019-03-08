package de.nacs.handshake;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertThat;

@SpringBootTest
class HandshakeMoveTest {

    @Autowired
    HandshakeMove handshakeMove;

    @ParameterizedTest
    @CsvSource(
            {
                    "2,thumb touches back",
                    "3,little finger grab",
                    "5,tickles over palm",
                    "6,bro knock",
                    "9,thousand knuckles"
            })
    void setHandshakes(Integer number, String move) {
        Map<Integer, String> handshakes = handshakeMove.getHandshakes();
        Assertions.assertTrue(handshakes.containsKey(number) && handshakes.containsValue(move));
        assertThat(handshakes, IsMapContaining.hasEntry(number, move));
    }

}
package de.nacs.handshake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NumberTest {

    @Autowired
    Number number;

    @ParameterizedTest
    @CsvSource({
            "1 - 2 - 4,124",
            "4 - 5 - 6 - 7,4567",
            "3 - 4,34"
    })
    void checkSplitter(String numbers, Integer digits) {
        List<String> split = List.of(numbers.split(" - "));
        List<Integer> expected = split.stream()
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());

        List<Integer> actual = number.split(digits);
        Assertions.assertEquals(expected, actual);

    }

}
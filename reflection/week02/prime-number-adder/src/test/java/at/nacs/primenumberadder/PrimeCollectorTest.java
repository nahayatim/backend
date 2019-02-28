package at.nacs.primenumberadder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeCollectorTest {

    @Autowired
    PrimeCollector primeCollector;

    @Autowired
    PrimeAdder primeAdder;

    @ParameterizedTest
    @CsvSource({
            "24133, 100",
            "0, 0",
            "10, 3",
            "28, 5"
    })
    void collectPrimeNumbers(long expected, int numberOfPrimes) {

        List<Integer> primeNumbers = primeCollector.collectPrimeNumbers(numberOfPrimes);
        long actual = primeAdder.calculateSum(primeNumbers);

        assertEquals(expected, actual);
    }
}
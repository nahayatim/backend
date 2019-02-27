package at.nacs.primenumberadder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PrimeCollector.class)
class PrimeCollectorTest {

    @Autowired
    private PrimeCollector primeCollector;

    @Autowired
    private PrimeAdder primeAdder;

    @ParameterizedTest
    @CsvSource({
            "24133, 100",
            "0, 0",
            "3, 10",
            "5, 28"
    })
    void collectPrimeNumbers(long expected, int numberOfPrimes) {

        List<Integer> primeNumbers = primeCollector.collectPrimeNumbers(numberOfPrimes);
        long actual = primeAdder.calculateSum(primeNumbers);

        assertEquals(expected, actual);
    }
}
package at.nacs.primenumberadder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimesTest {

    @Autowired
    Primes primes;

    @ParameterizedTest
    @CsvSource({
           "false, -90",
            "true, 3",
            "false, 22",
            "true, 13",
            "false, 100",
            "true, 997",
    })
    void testPrimeNumbers(boolean expected, int number) {
        boolean actual = primes.isPrime(number);

        Assertions.assertEquals(expected,actual);
    }

}
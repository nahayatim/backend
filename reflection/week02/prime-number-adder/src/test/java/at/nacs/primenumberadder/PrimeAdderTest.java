package at.nacs.primenumberadder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PrimeAdderTest {

    @Autowired
    PrimeAdder primeAdder;

    @Autowired
    PrimeCollector primeCollector;

    @Autowired
    Primes primes;

    @ParameterizedTest
    @CsvSource({
            "5, 2, 3"
//            "378282346310005, false",
//            "371847579533915, true",
//            "5114266492307268, true",
//            "4417123456789113, true",
//            "2437123456789113, false" //this is not a credit card number, but current implementation treats it like that
    })
    void calculateSum(long expected, int number1, int number2) {
        List<Integer> primeNumbers = List.of(number1, number2);
        long actual = primeAdder.calculateSum(primeNumbers);
        System.out.println(primeNumbers);

        assertEquals(expected, actual);
    }

    @Test
    void calculateSumOfHundredPrimes() {
        List<Integer> primeNumbers = primeCollector.collectPrimeNumbers(100);
        long actual = primeAdder.calculateSum(primeNumbers);

        assertEquals(24133, actual);
    }
}
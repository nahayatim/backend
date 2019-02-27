package at.nacs.primenumberadder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes =  PrimeAdder.class)

class PrimeAdderTest {

    @Autowired
    private PrimeAdder primeAdder;

    @ParameterizedTest
    @CsvSource({
            " 10,new Arrays.asList(2,3,5)",
//            "378282346310005, false",
//            "371847579533915, true",
//            "5114266492307268, true",
//            "4417123456789113, true",
//            "2437123456789113, false" //this is not a credit card number, but current implementation treats it like that
    })

    @Test
    void calculateSum(long expected, List<Integer>primeNumbers) {
        long actual = primeAdder.calculateSum(primeNumbers);

        assertEquals(expected, actual);


    }
}
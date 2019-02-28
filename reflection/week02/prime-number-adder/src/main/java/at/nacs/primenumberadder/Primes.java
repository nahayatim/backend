package at.nacs.primenumberadder;


import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@Value
public class Primes {

    public boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }
        System.out.println("testing "+ number);
        return (IntStream.rangeClosed(2, number / 2))
                .peek(e -> System.out.println("checking " + e))
                .noneMatch(i -> number % i == 0);
    }
}
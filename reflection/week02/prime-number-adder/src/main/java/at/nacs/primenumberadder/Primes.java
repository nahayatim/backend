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
        return IntStream.range(2, (int) (Math.sqrt(number)))
                .noneMatch(n -> number % n == 0);

    }
}

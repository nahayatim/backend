package at.nacs.primenumberadder;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Value
public class PrimeCollector {

    private Primes primes;

    public List<Integer> collectPrimeNumbers(int n) {

        return IntStream.iterate(2, e -> e + 1)
                .filter(e -> primes.isPrime(e))
                .boxed()
                .limit(n)
                .collect(Collectors.toList());

    }
}



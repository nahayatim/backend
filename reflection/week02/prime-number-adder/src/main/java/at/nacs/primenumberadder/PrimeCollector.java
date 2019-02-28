package at.nacs.primenumberadder;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Value
public class PrimeCollector {

    Primes primes;

    public List<Integer> collectPrimeNumbers(int limit) {
        return IntStream.iterate(2, e -> e + 1)
                .filter(primes::isPrime)
                .boxed()
                .limit(limit)
                .collect(Collectors.toList());
    }
}



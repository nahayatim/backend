package at.nacs.primenumber;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Value
@Component
public class PrimeCollector {

    private at.nacs.primenumber.Primes primes;

    public List<Integer> collectPrimeNumbers(int n) {

        List<Integer> primeNumbers = IntStream.iterate(2, e -> e + 1)
                .filter(e -> primes.isPrime(e))
                .boxed()
                .limit(n)
                .collect(Collectors.toList());
        return primeNumbers;
    }
}



package at.nacs.primenumberadder;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Value
public class PrimeAdder {

    PrimeCollector primeCollector;

    public long calculateSum(List<Integer> primeNumbers) {
        return primeNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

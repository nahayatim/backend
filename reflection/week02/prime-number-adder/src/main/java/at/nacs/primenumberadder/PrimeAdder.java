package at.nacs.primenumberadder;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Value
public class PrimeAdder {

    private PrimeCollector primeCollector;

    public long calculateSum(List<Integer> primeNumbers) {
        List<Integer> allNumbers = primeCollector.collectPrimeNumbers(100);
        Integer sum = allNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return sum;

    }
}

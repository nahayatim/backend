package at.nacs.primenumber;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Value
@Component
public class PrimeAdder {

    private PrimeCollector primeCollector;
    private long sum = 0;

    public long calculateSum(List<Integer> primeNumbers) {
        List<Integer> allNumbers = primeCollector.collectPrimeNumbers(100);
        Integer sum = allNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return sum;

    }
}

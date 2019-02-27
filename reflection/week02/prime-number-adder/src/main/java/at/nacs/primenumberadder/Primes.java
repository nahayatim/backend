package at.nacs.primenumber;


i

import java.util.stream.IntStream;


@Component
@Value

public class Primes {

    public boolean isPrime(int number) {
        return IntStream.range(2, (int) (Math.sqrt(number)))
                .noneMatch(n -> number % n == 0);

    }
}
// public static boolean CheckPrime(int numberToCheck) {
//        int remainder;
//        for (int i = 2; i <= numberToCheck / 2; i++) {
//            remainder = numberToCheck % i;
//            //if remainder is 0 than numberToCheckber is not prime and break loop. Elese continue loop
//            if (remainder == 0) {
//                return false;
//            }
//        }
//        return true;
//
//    }
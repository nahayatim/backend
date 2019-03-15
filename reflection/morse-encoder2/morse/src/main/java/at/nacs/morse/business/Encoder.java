package at.nacs.morse.business;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Encoder {

    private final Alphabet alphabet;


    public String encode(String letter) {

        return alphabet.getMorsealphabet().get(letter);

    }
}

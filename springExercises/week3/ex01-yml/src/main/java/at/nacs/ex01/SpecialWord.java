package at.nacs.ex01;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpecialWord {
    @Getter
    @Value("${special.word}")
    private String word;
}

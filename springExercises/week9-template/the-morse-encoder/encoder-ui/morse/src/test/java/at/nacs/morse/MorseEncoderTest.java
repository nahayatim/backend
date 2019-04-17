package at.nacs.morse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class MorseEncoderTest {

    @Autowired
    MorseEncoder morseEncoder;

    @ParameterizedTest
    @CsvSource({
            "1, a",
            "2, b",
            "NOT SUPPORTED, c"
    })
    void encode(String expected, String letter) {
        String actual = morseEncoder.encode(letter);

        assertThat(actual).isEqualTo(expected);
    }
}
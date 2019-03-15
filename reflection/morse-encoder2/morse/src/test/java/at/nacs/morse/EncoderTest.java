package at.nacs.morse;


import at.nacs.morse.business.Encoder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EncoderTest {

    @Autowired
    Encoder encoder;

    @Test
    void encode() {
         Assertions.assertThat(encoder.encode("A").equals(".-"));

    }

}
package at.nacs.ex01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaunaLoaderTest {

    @Autowired
    SaunaLoader saunaLoader;

    @Test
    void getSauna() {
        Sauna sauna = saunaLoader.getSauna();
        int availableseats = sauna.getAvailableseats();
        int temperature = sauna.getTemperature();
        Assertions.assertEquals(7, availableseats);
        Assertions.assertEquals(50, temperature);

    }


}
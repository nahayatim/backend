package at.nacs.ex01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BallerinaLoaderTest {

    @Autowired
    BallerinaLoader ballerinaLoader;

    @Test
    void getBallerinas() {
        List<Ballerina> ballerinas = ballerinaLoader.getBallerinas();
        assertEquals(3, ballerinas.size());
    }

    @ParameterizedTest
    @CsvSource({
            "0,tamara,3",
            "1,mahtab,4",
            "2,diba,5"
    })
    void testList(int position, String name, int quality) {
        List<Ballerina> ballerinas = ballerinaLoader.getBallerinas();
        Ballerina ballerina = ballerinas.get(position);

        Assertions.assertEquals(name, ballerina.getName());
        Assertions.assertEquals(quality, ballerina.getPerformancequality());
    }

}
package reflection.fruitshop.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import reflection.fruitshop.model.Fruit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class AssistantTest {

    @ParameterizedTest
    @CsvSource({
            "2 Apple, 'Apple,Apple'",
            "3 Watermelon, 'Watermelon,Watermelon,Watermelon'",
            "5 Orange, 'Orange,Orange,Orange,Orange,Orange'",
            "8 Banana, 'Banana,Banana,Banana,Banana,Banana,Banana,Banana,Banana'"
    })
    void testCounterBorad(String expected, String line) {
        List<String> names = Arrays.asList(line.split(","));

        List<Fruit> fruits = Assistant.toFruit(names);
        String actual = fruits.stream()
                .map(Fruit::toString)
                .collect(Collectors.joining());
        Assertions.assertEquals(expected, actual);
    }

}
package reflection.fruitshop.controller;

import lombok.experimental.UtilityClass;
import reflection.fruitshop.model.Fruit;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class Assistant {

    public List<Fruit> toFruit(List<String> lines) {

        return lines.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .map(e -> Fruit.builder().name(e.getKey()).amount(e.getValue()).build())
                .collect(Collectors.toList());
    }
}


package at.nacs.fruitshop.controller;

import at.nacs.fruitshop.model.Fruit;
import lombok.experimental.UtilityClass;

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


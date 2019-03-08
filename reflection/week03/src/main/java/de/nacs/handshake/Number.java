package de.nacs.handshake;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Number {

    public List<Integer> split(Integer number) {
        return Stream.of(number)
                .map(n -> n.toString())
                .map(n -> n.split(""))
                .flatMap(Stream::of)
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());

    }
}
package de.nacs.handshake;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class transformer {

    private final Number number;
    private final HandshakeMove handshakeMove;

    public List<String> transform(Integer price) {
        return Stream.of(number.split(price))
                .filter(handshakeMove.getHandshakes()::containsKey)
                .map(handshakeMove.getHandshakes()::get)
                .collect(Collectors.toList());

    }
}

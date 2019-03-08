package de.nacs.handshake;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class Transformer {

    private final Number number;
    private final HandshakeMove handshakeMove;

    public List<String> transform(Integer price) {
        return number.split(price).stream()
                .filter(handshakeMove.getHandshakes()::containsKey)
                .map(handshakeMove.getHandshakes()::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

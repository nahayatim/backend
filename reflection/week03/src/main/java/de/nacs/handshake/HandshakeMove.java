package de.nacs.handshake;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("handshake")
public class HandshakeMove {

    @Setter
    @Getter
    private Map<Integer, String> handshakes;
}

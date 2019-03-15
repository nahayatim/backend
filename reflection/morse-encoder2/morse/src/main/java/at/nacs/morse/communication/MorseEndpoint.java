package at.nacs.morse.communication;

import at.nacs.morse.business.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseEndpoint {


    private final Encoder encoder;

    @GetMapping("/{letter}")
    String get(@PathVariable String letter) {

        return encoder.encode(letter);
    }

}

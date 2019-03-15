package at.nacs.encoder.communication;

import at.nacs.encoder.business.CoderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
public class EncoderEndpoint {

    private final CoderClient coderClient;

    @PostMapping
    String post(@RequestBody String message){
        return coderClient.getAnswer(message);
    }
}

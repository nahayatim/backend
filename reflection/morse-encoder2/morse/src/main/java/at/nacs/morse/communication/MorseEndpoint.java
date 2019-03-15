package at.nacs.morse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
public class MorseEndpoint {


  private final Encoder encoder;

@GetMapping("/{letter}")
String get(@PathVariable String letter){
    return encoder.encode(letter);
}

 @PostMapping
    String post(@RequestBody String letter){
       String aa =encoder.encode(letter);
       return aa;

  }
}

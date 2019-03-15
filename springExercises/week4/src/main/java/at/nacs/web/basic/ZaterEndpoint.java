package at.nacs.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zater")
public class ZaterEndpoint {

    @GetMapping
    public String getMessage(){
        return "Zater is delicious";
    }
}

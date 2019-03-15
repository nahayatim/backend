package at.nacs.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delicious")
public class DeliciousEndpoint {

    @GetMapping
    String delicious(){
        return "you are delicious";
    }

    @GetMapping("/somebody")
    String sombodyIsDelicious(){
        return "Sombody is delicious";
    }

    @GetMapping("/{name}")
    String somebodyIsDelicious(@PathVariable String name){
        return name+ " is delicious";
    }
}

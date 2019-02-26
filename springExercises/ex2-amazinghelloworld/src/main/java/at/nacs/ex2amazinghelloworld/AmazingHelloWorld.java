package at.nacs.ex2amazinghelloworld;

import org.springframework.stereotype.Component;

@Component
public class AmazingHelloWorld {


    public String say(){
        return "Hello "+"World";
    }
}

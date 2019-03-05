package at.nacs.ex01;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("bookshop")
public class Bookshop {


    @Setter
    @Getter
    private Map<String, Integer> books;

}


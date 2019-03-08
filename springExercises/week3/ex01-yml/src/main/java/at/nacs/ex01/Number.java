package at.nacs.ex01;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Getter
@Component
public class Number {

    @Value("${value.number}")
    private Integer number;


}

package at.nacs.ex01;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Component
public class Weekdays {

    @Value("${day.week}")
    private List<String> days;


}

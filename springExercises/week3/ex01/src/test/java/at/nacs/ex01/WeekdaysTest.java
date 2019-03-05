package at.nacs.ex01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WeekdaysTest {

    @Autowired
    Weekdays weekdays;

    @ParameterizedTest
    @ValueSource(strings = {"saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"})
    void getDays(String day) {
        List<String> days = weekdays.getDays();
        Assertions.assertTrue(days.contains(day));
    }

    @ParameterizedTest
    @CsvSource({"0,saturday","1,sunday","2,monday","3,tuesday","4,wednesday","5,thursday","6,friday"})
    void orderDays(int order,String day){
        List<String> days = weekdays.getDays();
        Assertions.assertEquals(day,days.get(order));

    }
}
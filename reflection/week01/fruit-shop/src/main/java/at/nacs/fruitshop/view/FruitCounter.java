package at.nacs.fruitshop.view;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import reflection.fruitshop.controller.Assistant;
import reflection.fruitshop.controller.FileReader;
import reflection.fruitshop.model.Fruit;

import java.util.List;

@UtilityClass
@Log
public class FruitCounter {

    //    FruitCounter - displays the list of fruits

    private List<String> fruitNames = (List<String>) FileReader.lines("reflection/fruitshop/file/delivery.txt");
    private List<Fruit> fruits = Assistant.toFruit(fruitNames);

    public void display() {
        log.info("These are all our tasteful fruits:");
        fruits.stream()
                .forEach(e -> System.out.println(e.getAmount() + " " + e.getName()));

    }


}

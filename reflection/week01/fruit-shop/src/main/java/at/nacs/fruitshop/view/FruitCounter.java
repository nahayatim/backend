package at.nacs.fruitshop.view;

import at.nacs.fruitshop.controller.Assistant;
import at.nacs.fruitshop.controller.FileReader;
import at.nacs.fruitshop.model.Fruit;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.util.List;

@UtilityClass
@Log
public class FruitCounter {

    //    FruitCounter - displays the list of fruits

    private List<String> fruitNames = (List<String>) FileReader.lines("at/nacs/fruitshop/file/delivery.txt");
    private List<Fruit> fruits = Assistant.toFruit(fruitNames);

    public void display() {
        log.info("These are all our tasteful fruits:");
        fruits.stream()
                .forEach(e -> System.out.println(e.getAmount() + " " + e.getName()));

    }


}

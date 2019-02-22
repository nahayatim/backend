package reflection.fruitshop.model;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Fruit {

    private String name;
    private long amount;

    @Override
    public String toString() {
        return amount + " " + name;
    }
}

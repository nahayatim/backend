import java.util.Arrays;
import java.util.List;

public class Verifications {

    private List<Validator> getValidators() {
        return Arrays.asList(
                new IsNotNull(), new ContainLowerCase(),
                new ContainUpperCase(), new ContainNumber(),
                new LongerThanEightCharacter()
        );
    }

    public boolean verifyAtleastThreeConditionAndContainLowerCase(String password) {
        List<Validator> validators = getValidators();
        long numberOfTrueConditions = validators.stream()
                .map(e -> e.isValid(password))
                .filter(e -> equals(true))
                .count();
        if (numberOfTrueConditions >= 3 && validators.get(1).isValid(password)) {
            return true;
        }
        return false;
    }
}

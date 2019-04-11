
public class LongerThanEightCharacter implements Validator {


    @Override
    public boolean isValid(String password) {
        return password.length() >= 8;
    }
}

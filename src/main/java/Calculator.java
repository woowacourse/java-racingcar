import java.util.Arrays;

public class Calculator {

    public static final String DELIMITER = ",";

    public static int calculate(String input) {
        String[] splitedInput = input.split(DELIMITER);
        int result = 0;
        for (String character : splitedInput) {
            result += Integer.parseInt(character);
        }
        return result;
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
    public static final String DELIMITER = ",|:";

    public int calculate(String input) {
        List<Integer> numbers = createNumbers(input);
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    public List<Integer> createNumbers(String st) {
        return Arrays.stream(st.split(DELIMITER))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }
}

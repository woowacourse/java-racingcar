import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
    public static final String END_CHARACTER = "\n";
    public static final int START_INDEX = 1;

    private String delimiter = ",|:";

    public void run() {
        String input = "1,2:3";
        if (hasCustomDelimiter(input)) {
            delimiter = getCustomDelimiter(input);
        }
        calculate(createNumbers(input, delimiter));
    }

    public int calculate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> createNumbers(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }

    public String getCustomDelimiter(String input) {
        StringBuilder customDelimiter = new StringBuilder();
        for (int i = START_INDEX; i < input.length(); i++) {
            if (END_CHARACTER.equals(input.substring(i, i+1))) {
                break;
            }
            customDelimiter.append(input.charAt(i));
        }
        return customDelimiter.toString();
    }

    public boolean hasCustomDelimiter(String input) {
        return input.charAt(0) == '\\' && input.contains(END_CHARACTER);
    }
}

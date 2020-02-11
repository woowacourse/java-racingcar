import java.util.ArrayList;
import java.util.List;

public class StringAdditionCalculator {
    public static final String END_CHARACTER = "\n";
    public static final char START_CHARACTER = '\\';
    public static final int ZERO = 0;
    public static final int FIRST_INDEX = 0;
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
        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : input.split(delimiter)) {
            numbers.add(convertToInteger(stringNumber));
        }

        return numbers;
    }

    private int convertToInteger(String stringNumber) {
        int number = 0;

        try {
            number = Integer.parseInt(stringNumber);
            validatePositiveNumber(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Input has something not number");
        }

        return number;
    }

    private void validatePositiveNumber(int number) {
        if (number < ZERO) {
            throw new RuntimeException("Input has negative number");
        }
    }

    public String getCustomDelimiter(String input) {
        StringBuilder customDelimiter = new StringBuilder();

        for (int i = START_INDEX; i < input.length(); i++) {
            if (END_CHARACTER.equals(input.substring(i, i + 1))) {
                break;
            }
            customDelimiter.append(input.charAt(i));
        }

        return customDelimiter.toString();
    }

    public boolean hasCustomDelimiter(String input) {
        return input.charAt(FIRST_INDEX) == START_CHARACTER
                && input.contains(END_CHARACTER);
    }
}

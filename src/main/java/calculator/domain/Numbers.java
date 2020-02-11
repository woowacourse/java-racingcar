package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static final int ZERO = 0;

    private List<Integer> numbers;

    public Numbers(String input, String delimiter) {
        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : input.split(delimiter)) {
            numbers.add(convertToInteger(stringNumber));
        }

        this.numbers = numbers;
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}

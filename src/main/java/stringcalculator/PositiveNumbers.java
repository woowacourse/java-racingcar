package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {

    public static final int NEGATIVE = -1;
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "%s는 숫자가 아닙니다.";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "%d는 음수입니다.";

    private List<Integer> numbers;

    public PositiveNumbers(List<String> maybeNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String maybeNumber : maybeNumbers) {
            Integer number = parseInt(maybeNumber);
            numbers.add(number);
        }
        this.numbers = numbers;
    }

    private Integer parseInt(String maybeNumber) {
        try {
            return parsePositiveInt(Integer.parseInt(maybeNumber));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format(NUMBER_FORMAT_EXCEPTION_MESSAGE, maybeNumber));
        }
    }

    private Integer parsePositiveInt(Integer maybePositive) {
        if (maybePositive > NEGATIVE) {
            return maybePositive;
        }
        throw new IllegalArgumentException(String.format(NEGATIVE_NUMBER_EXCEPTION_MESSAGE, maybePositive));
    }

    public Integer getSum() {
        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}

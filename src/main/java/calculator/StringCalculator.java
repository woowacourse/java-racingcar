package calculator;

import calculator.utils.validator.StringNumberValidator;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int calculate(List<String> stringNumbers) {
        checkRightPositiveInteger(stringNumbers);
        List<Integer> numberList = toNumberList(stringNumbers);
        return numberList.stream().mapToInt(num -> num).sum();
    }

    private static void checkRightPositiveInteger(List<String> numberStringList) {
        numberStringList.forEach(StringNumberValidator::validate);
    }

    private static List<Integer> toNumberList(List<String> numberStringList) {
        return numberStringList.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}

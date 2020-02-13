package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String NUMBER_EXPRESSION = "^~[0-9]+$";

    public static int calculate(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitedInputs = StringSpliter.split(input);
        validExceptPositiveNumberAndZero(splitedInputs);
        int result = Arrays.stream(splitedInputs)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();
        return result;
    }

    public static void validExceptPositiveNumberAndZero(String[] inputs) {
        boolean isNotPositiveNumberAndZero = Arrays.stream(inputs)
                .anyMatch(input -> input.matches(NUMBER_EXPRESSION));
        if (isNotPositiveNumberAndZero) {
            System.out.println("숫자 이외의 값 혹은 음수가 입력되었습니다.");
            throw new RuntimeException();
        }
    }
}

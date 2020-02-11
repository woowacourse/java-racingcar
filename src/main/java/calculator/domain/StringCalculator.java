package calculator.domain;

import calculator.util.DelimiterUtil;

public class StringCalculator {
    public static int run(String value) {
        if (isNullOrBlank(value)) {
            return 0;
        }
        return calculate(value);
    }

    private static int calculate(String value) {
        String[] numbers = DelimiterUtil.parseString(value);
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}

package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String text) throws RuntimeException {
        if (text == null || text.isEmpty())
            return 0;
        int number;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            return addElements(tokens);
        }

        String[] numbers = text.split(",|:");
        if (numbers.length >= 2){
            return addElements(numbers);
        }

        number = checkNegative(text);
        return number;
    }

    private static int addElements(String[] numbers) throws RuntimeException {
        int number = 0;
        for (int i = 0; i < numbers.length; i++){
            number += checkNegative(numbers[i]);
        }
        return number;
    }

    private static int checkNegative(String numberText) throws RuntimeException {
        int parsedNumber = Integer.parseInt(numberText);
        if (parsedNumber < 0) {
            throw new RuntimeException();
        }
        return parsedNumber;
    }
}

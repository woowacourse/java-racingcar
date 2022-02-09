package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int sum(String input) {
        if (!validateNullAndBlank(input)) {
            return 0;
        }
        List<Integer> numbers = parseStringsToInts(splitByDelimiter(input));

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static String[] splitByDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static List<Integer> parseStringsToInts(String[] numbers) {
        List<Integer> resultList = new ArrayList<>();
        for(String number : numbers) {
            resultList.add(Integer.parseInt(number));
        }
        return resultList;
    }

    private static boolean validateNullAndBlank(String input) {
        return input != null && !input.isEmpty();
    }
}

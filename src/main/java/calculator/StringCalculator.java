package calculator;

import calculator.util.InputStrValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String inputStr) {
        if (InputStrValidator.isEmptyOrNull(inputStr)) {
            return 0;
        }
        if (InputStrValidator.isOnlyOneNumber(inputStr)) {
            return Integer.parseInt(inputStr);
        }
        return sumNumbers(splitInputStr(inputStr));
    }

    private static int sumNumbers(List<Integer> numbers) {
        return 0;
    }

    private static List<Integer> splitInputStr(String inputStr) {
        List<Integer> numbers = new ArrayList<>();
        List<String> splitStings = Arrays.asList(inputStr.split(getDelimiter(inputStr)));
        return numbers;
    }

    private static String findCustomDelimiter(String inputStr) {
        //“//;\n1;2;3” => ;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputStr);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
        }
        return customDelimiter;
    }

    private static String getDelimiter(String inputStr) {
        String delimiter = ",|;";
        delimiter = delimiter + '|' + findCustomDelimiter(inputStr);
        return delimiter;
    }
}

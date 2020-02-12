package application.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static List<Integer> numbers = new ArrayList<>();
    private static String delimiter = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmptyText(text)) {
            return 0;
        }
        String[] splitString = getSplitString(text);
        addNumbers(splitString);
        return calculateNumberSum();
    }

    private static int calculateNumberSum() {
        int sum = 0;
        for (int integer : numbers) {
            sum = sum + integer;
        }
        return sum;
    }

    private static void addNumbers(String[] splitString) {
        for (String string : splitString) {
            int convertNumber = getConvertNumber(string);
            numbers.add(convertNumber);
        }
    }

    private static int getConvertNumber(String string) {
        return Integer.parseInt(string);
    }

    private static String[] getSplitString(String text) {
        return text.split(delimiter);
    }

    private static boolean isNullOrEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}

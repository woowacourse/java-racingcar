package application.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmptyText(text)) {
            return 0;
        }
        List<Integer> numbers = new ArrayList<>();
        String[] splitString = text.split(",");
        for (String string : splitString) {
            numbers.add(Integer.parseInt(string));
        }
        int sum = 0;
        for (int integer : numbers) {
            sum = sum + integer;
        }
        return sum;
    }

    private static boolean isNullOrEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}

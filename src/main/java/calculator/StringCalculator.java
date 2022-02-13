package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static final Parser parser = new Parser();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        splitAndSum("1,2,3");
    }

    public static int splitAndSum(String input) {
        String[] values = parser.splitter(input);
        parser.checkNumber(values);

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            nums.add(Integer.parseInt(values[i]));
        }

        return calculator.sum(nums);
    }
}

package calculator;

public class StringCalculator {
    private static final Parser parser = new Parser();
    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        splitAndSum("1,2,3");
    }

    public static int splitAndSum(String input) {
        String[] values = parser.splitter(input);
        parser.checkNumber(values);

        int[] nums = new int[values.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        return calculator.sum(nums);
    }
}

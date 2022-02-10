package stringcalculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        return calculate(castStringToInts(input));
    }

    private static int[] castStringToInts(String input) {
        if (isNullOrEmpty(input)) {
            return new int[] {0};
        }
        return null;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int calculate(int[] numbers) {
        //numbers를 계산
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}

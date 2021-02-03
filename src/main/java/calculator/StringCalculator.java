package calculator;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] numbers = text.split(",|:");
        int sum = 0;
        for (String number: numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}

package calculator;

public class StringCalculator {

    public static int splitAndSum(String text) {
        String[] numbers = text.split(",");
        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }
        return total;
    }
}

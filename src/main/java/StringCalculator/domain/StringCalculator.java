package stringcalculator.domain;

public class StringCalculator {
    public static int splitAndSum(String input) {
        Input i = Input.valueOf(input);
        Numbers numbers = i.getNumbers();
        return numbers.sum();
    }
}

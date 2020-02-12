public class StringCalculator {
    public static int add(String numberExpression) {
        if (numberExpression.isEmpty()) {
            return 0;
        }

        String[] words = numberExpression.split(",");
        if (words.length == 1) {
            words = numberExpression.split(":");
        }

        int firstNumber = Integer.parseInt(words[0]);
        int secondNumber = Integer.parseInt(words[1]);

        return firstNumber + secondNumber;
    }
}

public class StringCalculator {
    public static int add(String numberExpression) {
        if (numberExpression.isEmpty()) {
            return 0;
        }

        String[] words = numberExpression.split(",");
        if (words.length == 1) {
            words = numberExpression.split(":");
        }

        int result = 0;
        for (String word : words) {
            result += Integer.parseInt(word);
        }

        return result;
    }
}

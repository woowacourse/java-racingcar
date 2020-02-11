public class StringCalculator {
    public static int add(String s) {
        String[] words = s.split(",");
        int firstNumber = Integer.parseInt(words[0]);
        int secondNumber = Integer.parseInt(words[1]);

        return firstNumber + secondNumber;
    }
}

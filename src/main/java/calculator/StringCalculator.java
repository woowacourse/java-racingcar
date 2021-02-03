package calculator;

public class StringCalculator {
    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            return Integer.parseInt(string);
        }

        String[] numbers = string.split(",");
        int result = 0;
        if (numbers.length == 2) {
            for (String number : numbers) {
                if (!checkDigit(number)) {
                    throw new RuntimeException();
                }
                result += Integer.parseInt(number);
            }
        }

        return result;
    }

    private static boolean checkDigit(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

package addCalculatorTest;

public class StringCalculator {
    private static final String DELIMITERS = "-:,;";

    public static int splitAndSum(String s) {
        if (isNullOrBlank(s)) {
            return 0;
        }

        if (isOneLengthDigit(s)) {
            return Integer.parseInt(s);
        }

        int sum = 0;
        for (String number : removeWrongCharacters(s).split(",|:|;")) {
            sum += extractInt(number);
        }

        return sum;
    }

    private static boolean isNullOrBlank(final String s) {
        if (s == null || s == "") {
            return true;
        }
        return false;
    }

    private static boolean isOneLengthDigit(final String s) {
        if (s.length() == 1 && "0123456789".contains(s)){
            return true;
        }
        return false;
    }

    private static boolean isDelimOrDigit(final char c) {
        if (DELIMITERS.contains(Character.toString(c)) || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    private static String removeWrongCharacters(final String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (isDelimOrDigit(c)) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    private static int extractInt(final String numberString) {
        if (numberString.contains("-")) {
            throw new RuntimeException();
        }
        if (numberString.equals("")) {
            return 0;
        }
        return Integer.parseInt(numberString);
    }
}

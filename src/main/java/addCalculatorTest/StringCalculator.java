package addCalculatorTest;

import java.util.Arrays;

public class StringCalculator {
    public static void main(String[] args) {
    }

    public static int splitAndSum(String s) {
        if (s == null || s == "") {
            return 0;
        }

        if (!(s.contains(",") || s.contains(":") || s.contains(";"))) {
            return Integer.parseInt(s);
        }

        //
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '-' || c == ':' || c == ',' || c == ';' || (c >= '0' && c <= '9')) {
                stringBuilder.append(c);
            }
        }

        String[] split = stringBuilder.toString().split(",|:|;");

        int sum = 0;
        for (String number : split) {
            if (number.contains("-")) {
                throw new RuntimeException();
            }
            if (number.equals("")) {
                continue;
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}

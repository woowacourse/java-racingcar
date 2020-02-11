package calculator;

public class StringCalculator {

    public static int calculate(String input) {
        String[] values = input.split(",");
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            String[] values2 = values[i].split(":");
            for (String value :values2) {
                result += Integer.parseInt(value);
            }
        }

        return result;
    }

}

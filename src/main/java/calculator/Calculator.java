package calculator;

public class Calculator {

    public static int splitAndSum(String str) {
        int sum = 0;

        if (str == null || str.length() == 0) {
            return 0;
        }

        String[] split = str.split(",");

        for (String s : split) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}

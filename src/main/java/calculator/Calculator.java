package calculator;

public class Calculator {

    public static int splitAndSum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        return Integer.parseInt(str);
    }
}

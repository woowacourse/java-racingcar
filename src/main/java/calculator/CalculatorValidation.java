package calculator;

public class CalculatorValidation {

    private CalculatorValidation() {
    }

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static void isValidTokens(String[] tokens) {
        for (String token : tokens) {
            isDigit(token);
            isNegativeNumber(token);
        }
    }

    private static void isDigit(String token) {
        try {
            Integer.parseInt(token);
        } catch(NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다!");
        }
    }

    private static void isNegativeNumber(String token) {
        int num = Integer.parseInt(token);

        if (num < 0){
            throw new RuntimeException("음수는 안됩니다!");
        }
    }
}

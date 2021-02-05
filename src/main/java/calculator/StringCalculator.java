package calculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        if (isNull(input)) {
            return 0;
        }
        
        final String[] numbers = new Parser(input).parse();
        
        return sum(numbers);
    }
    
    private static boolean isNull(String input) {
        return input == null;
    }
    
    private static int sum(String[] numbers) {
        int result = 0;
        
        for (String number : numbers) {
            result += ZeroAndPositiveNumber.from(number)
                                           .getNumber();
        }
        
        return result;
    }
}

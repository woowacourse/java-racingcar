package calculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        if (input == null) {
            return 0;
        }
        
        String[] tokens = new StringSplitter(input).getStringSplitter();
        
        return sum(tokens);
    }
    
    private static int sum(String[] tokens) {
        int result = 0;
        
        for (String token : tokens) {
            result += new ZeroAndPositiveNumber(token).getValue();
        }
        
        return result;
    }
}

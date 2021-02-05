package calculator;

public class StringCalculator {
    public static int splitAndSum(String input) {
        if (input == null) {
            return 0;
        }
        
        String[] numbers = new StringSplitter(input).getNumbers();
        
        return sum(numbers);
    }
    
    private static int sum(String[] numbers) {
        int result = 0;
        
        for (String token : numbers) {
            result += new ZeroAndPositiveNumber(token).getValue();
        }
        
        return result;
    }
}

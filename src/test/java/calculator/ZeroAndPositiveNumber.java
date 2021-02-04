package calculator;

public class ZeroAndPositiveNumber {
    
    private final int number;
    
    public ZeroAndPositiveNumber(String token) {
        number = Integer.parseInt(token);
        
        if (number < 0) {
            throw new RuntimeException();
        }
    }
    
    public int getValue() {
        return number;
    }
}

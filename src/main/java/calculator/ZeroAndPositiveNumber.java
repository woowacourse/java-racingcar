package calculator;

public class ZeroAndPositiveNumber {
    
    private final String number;
    
    public ZeroAndPositiveNumber(String number) {
        this.number = number;
    }
    
    public int getValue() {
        if (number.isEmpty()) {
            return 0;
        }
    
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < 0) {
            throw new RuntimeException();
        }
        
        return parsedNumber;
    }
}

package calculator;

class ZeroAndPositiveNumber {
    
    private final int number;
    
    private ZeroAndPositiveNumber(int number) {
        this.number = number;
    }
    
    public static ZeroAndPositiveNumber from(String number) {
        if (number.isEmpty()) {
            return new ZeroAndPositiveNumber(0);
        }
        
        int parsedNumber = Integer.parseInt(number);
        if (isNegative(parsedNumber)) {
            throw new RuntimeException();
        }
        
        return new ZeroAndPositiveNumber(parsedNumber);
    }
    
    private static boolean isNegative(int parsedNumber) {
        return parsedNumber < 0;
    }
    
    public int getNumber() {
        return number;
    }
}

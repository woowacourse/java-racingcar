package calculator;

public class Number {
    public static final int ZERO = 0;
    private final int number;

    public Number(String number) {
        this.number = validateNumber(number);
    }

    private int validateNumber(String number) {
        if(number == null || number.isEmpty()){
            return ZERO;
        }

        try{
            return makePositiveNumber(number);
        } catch(NumberFormatException e){
            throw new RuntimeException();
        }
    }

    private int makePositiveNumber(String number) {
        int result = Integer.parseInt(number);
        if(result < ZERO){
            throw new RuntimeException();
        }
        return result;
    }

    public int getNumber() {
        return number;
    }
}

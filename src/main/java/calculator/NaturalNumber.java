package calculator;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(String value) {
        int number = Integer.parseInt(value);
        validateNegative(number);
        this.number = number;
    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public int get() {
        return number;
    }
}
